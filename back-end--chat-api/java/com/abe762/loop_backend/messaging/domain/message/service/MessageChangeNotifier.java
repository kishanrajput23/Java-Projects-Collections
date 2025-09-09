package com.abe762.loop_backend.messaging.domain.message.service;

import com.abe762.loop_backend.infrastructure.secondary.message.ConversationViewedForNotification;
import com.abe762.loop_backend.messaging.domain.message.aggregate.Message;
import com.abe762.loop_backend.messaging.domain.message.vo.ConversationPublicId;
import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;
import com.abe762.loop_backend.shared.service.State;

import java.util.List;

public interface MessageChangeNotifier {

    State<Void, String> send(Message message, List<UserPublicId> userToNotify);

    State<Void, String> delete(ConversationPublicId conversationPublicId, List<UserPublicId> userToNotify);

    State<Void, String> view(ConversationViewedForNotification conversationViewedForNotification, List<UserPublicId> usersToNotify);
}
