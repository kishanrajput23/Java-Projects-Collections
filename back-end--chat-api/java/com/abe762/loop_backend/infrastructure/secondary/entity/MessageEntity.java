package com.abe762.loop_backend.infrastructure.secondary.entity;

import com.abe762.loop_backend.messaging.domain.message.aggregate.Message;
import com.abe762.loop_backend.messaging.domain.message.aggregate.MessageBuilder;
import com.abe762.loop_backend.messaging.domain.message.vo.*;
import com.abe762.loop_backend.messaging.domain.user.vo.UserPublicId;
import com.abe762.loop_backend.shared.jpa.AbstractAuditingEntity;
import jakarta.persistence.*;
import org.jilt.Builder;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "message")
@Builder
public class MessageEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageSequenceGenerator")
    @SequenceGenerator(name = "messageSequenceGenerator", sequenceName = "message_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "public_id", nullable = false, updatable = false)
    private UUID publicId;

    @Column(name = "send_time", nullable = false)
    private Instant sendTime;

    @Column(name = "text", nullable = false)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MessageType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "send_state")
    private MessageSendState sendState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk_sender", nullable = false)
    private UserEntity sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_fk", nullable = false)
    private ConversationEntity conversation;

    @OneToOne
    @JoinColumn(name = "message_binary_content_fk", referencedColumnName = "id")
    private MessageContentBinaryEntity contentBinary;

    public MessageEntity() {
    }

    public MessageEntity(Long id, UUID publicId, Instant sendTime, String text, MessageType type,
                         MessageSendState sendState, UserEntity sender, ConversationEntity conversation, MessageContentBinaryEntity contentBinary) {
        this.id = id;
        this.publicId = publicId;
        this.sendTime = sendTime;
        this.text = text;
        this.type = type;
        this.sendState = sendState;
        this.sender = sender;
        this.conversation = conversation;
        this.contentBinary = contentBinary;
    }

    public static MessageEntity from(Message message) {
        com.abe762.loop_backend.messaging.domain.message.service.infrastructure.secondary.entity.MessageEntityBuilder messageEntityBuilder = com.abe762.loop_backend.messaging.domain.message.service.infrastructure.secondary.entity.MessageEntityBuilder.messageEntity();

        if (message.getContent().type().equals(MessageType.TEXT)) {
            messageEntityBuilder.text(message.getContent().text());
        } else {
            messageEntityBuilder
                    .contentBinary(MessageContentBinaryEntity.from(message.getContent()));
            if (message.getContent().text() != null) {
                messageEntityBuilder.text(message.getContent().text());
            }
        }

        UserEntity user = com.abe762.loop_backend.messaging.domain.message.service.infrastructure.secondary.entity.UserEntityBuilder.userEntity()
                .publicId(message.getSender().value()).build();

        messageEntityBuilder
                .type(message.getContent().type())
                .publicId(message.getPublicId().value())
                .sendTime(message.getSentTime().date())
                .sendState(message.getSendState())
                .sender(user);

        return messageEntityBuilder.build();
    }

    public static Message toDomain(MessageEntity messageEntity) {
        MessageBuilder messageBuilder = MessageBuilder.message()
                .conversationId(new ConversationPublicId(messageEntity.getPublicId()))
                .sendState(messageEntity.getSendState())
                .sentTime(new MessageSentTime(messageEntity.getSendTime()))
                .sender(new UserPublicId(messageEntity.getSender().getPublicId()))
                .publicId(new MessagePublicId(messageEntity.getPublicId()));

        if (messageEntity.getType().equals(MessageType.TEXT)) {
            MessageContent content = new MessageContent(messageEntity.getText(), MessageType.TEXT, null);
            messageBuilder.content(content);
        } else {
            MessageMediaContent messageMediaContent = new
                    MessageMediaContent(messageEntity.getContentBinary().getFile(),
                    messageEntity.getContentBinary().getFileContentType());
            MessageContent content = new MessageContent(messageEntity.getText(), messageEntity.getType(), messageMediaContent);
            messageBuilder.content(content);
        }

        return messageBuilder.build();
    }

    public static Set<Message> toDomain(Set<MessageEntity> messages) {
        return messages.stream().map(MessageEntity::toDomain).collect(Collectors.toSet());
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public Instant getSendTime() {
        return sendTime;
    }

    public void setSendTime(Instant sendTime) {
        this.sendTime = sendTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public MessageSendState getSendState() {
        return sendState;
    }

    public void setSendState(MessageSendState sendState) {
        this.sendState = sendState;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public ConversationEntity getConversation() {
        return conversation;
    }

    public void setConversation(ConversationEntity conversation) {
        this.conversation = conversation;
    }

    public MessageContentBinaryEntity getContentBinary() {
        return contentBinary;
    }

    public void setContentBinary(MessageContentBinaryEntity contentBinary) {
        this.contentBinary = contentBinary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(publicId, that.publicId) && Objects.equals(sendTime, that.sendTime) && Objects.equals(text, that.text) && type == that.type && sendState == that.sendState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicId, sendTime, text, type, sendState);
    }
}
