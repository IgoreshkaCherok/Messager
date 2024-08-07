package com.messager.model.domain.messages;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_message")
    private Long idMessage;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "message")
    private String message;

    @Column(name = "id_user_send")
    private Long idUserSend;

    @Column(name = "id_attachment")
    private Long idAttachment;

    @Column(name = "id_conversation")
    private Long idConversation;
}
