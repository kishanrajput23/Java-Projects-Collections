package com.abe762.loop_backend.infrastructure.secondary.message;

import com.abe762.loop_backend.messaging.domain.user.aggregate.User;
import com.abe762.loop_backend.messaging.domain.user.vo.UserEmail;
import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.*;


@Service
public class NotificationService {

    private final UsersApplicationService usersApplicationService;

    public NotificationService(UsersApplicationService usersApplicationService) {
        this.usersApplicationService = usersApplicationService;
    }

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private Map<String, SseEmitter> emitters = new HashMap<>();

    @Scheduled(fixedRate = 5000)
    public void heartBeat() throws IOException {
        for (Map.Entry<String, SseEmitter> sseEmitter : emitters.entrySet()) {
            try {
                sseEmitter.getValue().send(SseEmitter.event()
                        .name("heartbeat")
                        .id(sseEmitter.getKey())
                        .data("Check heartbeat..."));
                this.usersApplicationService.updatePresence(
                        new UserPublicId(UUID.fromString(sseEmitter.getKey())));
            } catch (IllegalStateException e) {
                log.info("remove this one from the map {}", sseEmitter.getKey());
                this.emitters.remove(sseEmitter.getKey());
            }
        }
    }

    public SseEmitter addEmitter(UserEmail userEmail) {
        Optional<User> userByEmail = this.usersApplicationService.getUserByEmail(userEmail);
        if (userByEmail.isPresent()) {
            log.info("new Emitter added to the list : {}", userEmail.value());
            SseEmitter newEmitter = new SseEmitter(60000L);
            try {
                UUID userUUID = userByEmail.get().getUserPublicId().value();
                newEmitter.send(SseEmitter.event()
                        .id(userUUID.toString())
                        .data("Starting connection..."));
                this.emitters.put(userUUID.toString(), newEmitter);
                return newEmitter;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void sendMessage(Object message,
                            List<UserPublicId> usersToNotify,
                            NotificationEventName notificationEventName) {
        for (UserPublicId userId : usersToNotify) {
            String userUUIDRaw = userId.value().toString();
            if (this.emitters.containsKey(userUUIDRaw)) {
                log.info("located userpublicid, let send him message : {}", userUUIDRaw);
                SseEmitter sseEmitter = this.emitters.get(userUUIDRaw);
                try {
                    sseEmitter.send(SseEmitter.event()
                            .name(notificationEventName.value)
                            .id(userUUIDRaw)
                            .data(message));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
