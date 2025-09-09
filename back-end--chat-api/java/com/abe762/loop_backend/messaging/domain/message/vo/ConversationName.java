package com.abe762.loop_backend.messaging.domain.message.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

public record ConversationName(String name) {

    public ConversationName {
        Assert.field("name", name).minLength(3).maxLength(255);
    }
}
