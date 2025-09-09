package com.abe762.loop_backend.messaging.domain.message.vo;

public record MessageMediaContent(byte[] file,
                                  String mimetype) {
}
