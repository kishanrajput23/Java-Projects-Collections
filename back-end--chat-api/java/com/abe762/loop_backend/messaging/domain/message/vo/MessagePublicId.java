package com.abe762.loop_backend.messaging.domain.message.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

import java.util.UUID;

public record MessagePublicId(UUID value) {

    public MessagePublicId {
        Assert.notNull("Id can't be null", value);
    }
}
