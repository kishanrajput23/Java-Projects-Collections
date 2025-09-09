package com.abe762.loop_backend.messaging.domain.user.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

import java.util.UUID;

public record UserPublicId(UUID value) {
    public UserPublicId {
        Assert.notNull("value can't be null", value);
    }
}
