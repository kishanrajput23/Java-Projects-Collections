package com.abe762.loop_backend.messaging.domain.message.aggregate;

import com.abe762.loop_backend.shared.error.domain.Assert;

import java.util.List;

public record Messages(List<Messages> messages) {
    public Messages {
        Assert.field("messages", messages).notNull().noNullElement();
    }
}
