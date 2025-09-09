package com.abe762.loop_backend.messaging.domain.message.service;

import com.abe762.loop_backend.messaging.domain.message.aggregate.Conversation;
import com.abe762.loop_backend.messaging.domain.message.repository.ConversationRepository;
import com.abe762.loop_backend.messaging.domain.message.vo.ConversationPublicId;
import com.abe762.loop_backend.messaging.domain.user.aggregate.User;
import com.abe762.loop_backend.shared.service.State;

import java.util.Optional;

public class ConversationDeleter {

    private final ConversationRepository conversationRepository;
    private final MessageChangeNotifier messageChangeNotifier;

    public ConversationDeleter(ConversationRepository conversationRepository, MessageChangeNotifier messageChangeNotifier) {
        this.conversationRepository = conversationRepository;
        this.messageChangeNotifier = messageChangeNotifier;
    }

    public State<ConversationPublicId, String> deleteById(ConversationPublicId conversationId, User connectedUser) {
        State<ConversationPublicId, String> stateResult;

        Optional<Conversation> conversationToDeleteOpt = this.conversationRepository.getConversationByUsersPublicIdAndPublicId(connectedUser.getUserPublicId(), conversationId);
        if (conversationToDeleteOpt.isPresent()) {
            this.conversationRepository.deleteByPublicId(connectedUser.getUserPublicId(), conversationId);
            messageChangeNotifier.delete(conversationId, conversationToDeleteOpt.get()
                    .getMembers().stream().map(User::getUserPublicId).toList());
            stateResult = State.<ConversationPublicId, String>builder().forSuccess(conversationId);
        } else {
            stateResult = State.<ConversationPublicId, String>builder().forError("This conversation doesn't belong to this user or doesn't exist");
        }
        return stateResult;
    }
}
