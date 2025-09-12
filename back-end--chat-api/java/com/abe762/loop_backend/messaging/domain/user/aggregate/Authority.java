package com.abe762.loop_backend.messaging.domain.user.aggregate;

import com.abe762.loop_backend.messaging.domain.user.vo.AuthorityName;
import com.abe762.loop_backend.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public class Authority {
    private AuthorityName name;

    public Authority(AuthorityName name) {
        Assert.notNull("name", name);
        this.name = name;
    }

    public AuthorityName getName() {
        return name;
    }
}
