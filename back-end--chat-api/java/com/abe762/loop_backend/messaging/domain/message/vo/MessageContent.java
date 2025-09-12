package com.abe762.loop_backend.messaging.domain.message.vo;

import org.jilt.Builder;

import java.awt.*;

@Builder
public record MessageContent(String text,
                             MessageType type,
                             MessageMediaContent media) {
}
