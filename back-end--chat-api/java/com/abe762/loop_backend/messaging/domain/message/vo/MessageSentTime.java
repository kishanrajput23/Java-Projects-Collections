package com.abe762.loop_backend.messaging.domain.message.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

import java.time.Instant;

public record MessageSentTime(Instant date) {

    public MessageSentTime {
        Assert.field("date", date).notNull();
    }
}
