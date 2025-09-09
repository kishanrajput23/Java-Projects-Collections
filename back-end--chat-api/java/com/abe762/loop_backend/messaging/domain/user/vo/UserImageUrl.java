package com.abe762.loop_backend.messaging.domain.user.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

public record UserImageUrl(String value) {

    public UserImageUrl {
        Assert.field(value, value).maxLength(255);
    }
}
