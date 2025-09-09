package com.abe762.loop_backend.infrastructure.secondary.message;

import com.abe762.loop_backend.messaging.domain.message.aggregate.Message;
import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public record MessageWithUsers(Message message, List<UserPublicId> userToNotify) {
}
