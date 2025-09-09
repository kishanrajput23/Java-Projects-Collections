package com.abe762.loop_backend.messaging.domain.message.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

import java.util.UUID;

public record ConversationPublicId(UUID value) {

    public ConversationPublicId {
        Assert.notNull("Conservation cannot be null", value);
    }
}
