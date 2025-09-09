package com.abe762.loop_backend.infrastructure.secondary.message;

import com.abe762.loop_backend.messaging.domain.message.vo.ConversationPublicId;
import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public record ConversationIdWithUsers(ConversationPublicId conversationPublicId,
                                      List<UserPublicId> users) {
}
