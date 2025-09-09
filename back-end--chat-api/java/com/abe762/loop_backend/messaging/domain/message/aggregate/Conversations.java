package com.abe762.loop_backend.messaging.domain.message.aggregate;

import com.abe762.loop_backend.shared.error.domain.Assert;
import java.util.List;

public record Conversations(List<Conversation> conversations) {

    public Conversations {
        Assert.field("conversations", conversations).notNull().noNullElement();
    }
}
