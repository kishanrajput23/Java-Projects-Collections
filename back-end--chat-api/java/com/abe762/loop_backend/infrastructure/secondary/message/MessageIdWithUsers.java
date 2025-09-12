package com.abe762.loop_backend.infrastructure.secondary.message;

import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public record MessageIdWithUsers(ConversationViewedForNotification conversationViewedForNotification,
                                 List<UserPublicId> usersToNotify) {
}