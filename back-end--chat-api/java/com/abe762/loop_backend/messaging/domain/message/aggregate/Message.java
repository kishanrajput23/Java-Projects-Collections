package com.abe762.loop_backend.messaging.domain.message.aggregate;

import com.abe762.loop_backend.messaging.domain.message.vo.*;
import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;
import org.jilt.Builder;

@Builder
public class Message {
    private final MessageSentTime sentTime;

    private final MessageContent content;

    private final MessageSendState sendState;

    private final MessagePublicId publicId;

    private final UserPublicId sender;

    private final ConversationPublicId conversationId;

    public Message(MessageSentTime sentTime, MessageContent content,
                   MessageSendState sendState, MessagePublicId publicId,
                   UserPublicId sender, ConversationPublicId conversationId) {
        this.sentTime = sentTime;
        this.content = content;
        this.sendState = sendState;
        this.publicId = publicId;
        this.sender = sender;
        this.conversationId = conversationId;
    }

    public MessageSentTime getSentTime() {
        return sentTime;
    }

    public MessageContent getContent() {
        return content;
    }

    public MessageSendState getSendState() {
        return sendState;
    }

    public MessagePublicId getPublicId() {
        return publicId;
    }

    public UserPublicId getSender() {
        return sender;
    }

    public ConversationPublicId getConversationId() {
        return conversationId;
    }
}
