package com.abe762.loop_backend.infrastructure.secondary.entity;

import com.abe762.loop_backend.messaging.domain.message.vo.MessageContent;
import com.abe762.loop_backend.shared.jpa.AbstractAuditingEntity;
import jakarta.persistence.*;
import org.jilt.Builder;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "message_binary_content")
@Builder
public class MessageContentBinaryEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageContentBinarySequenceGenerator")
    @SequenceGenerator(name = "messageContentBinarySequenceGenerator",
            sequenceName = "message_binary_content_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "file", nullable = false)
    private byte[] file;

    @Column(name = "file_content_type")
    private String fileContentType;

    @OneToOne(mappedBy = "contentBinary")
    private MessageEntity message;


    public MessageContentBinaryEntity() {
    }

    public MessageContentBinaryEntity(Long id, byte[] file, String fileContentType, MessageEntity message) {
        this.id = id;
        this.file = file;
        this.fileContentType = fileContentType;
        this.message = message;
    }

    public static MessageContentBinaryEntity from(MessageContent messageContent) {
        return com.abe762.loop_backend.messaging.domain.message.service.infrastructure.secondary.entity.MessageContentBinaryEntityBuilder.messageContentBinaryEntity()
                .fileContentType(messageContent.media().mimetype())
                .file(messageContent.media().file())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageContentBinaryEntity that = (MessageContentBinaryEntity) o;
        return Objects.deepEquals(file, that.file) && Objects.equals(fileContentType, that.fileContentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(file), fileContentType);
    }
}
