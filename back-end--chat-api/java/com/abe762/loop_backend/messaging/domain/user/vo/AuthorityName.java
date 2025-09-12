package com.abe762.loop_backend.messaging.domain.user.vo;

import com.abe762.loop_backend.shared.error.domain.Assert;

public record AuthorityName(String name) {

    public AuthorityName {
        Assert.field("name", name).notNull();
    }
}
