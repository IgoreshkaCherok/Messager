package com.messager.model.domain.messages;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@DynamicInsert
@DynamicUpdate

public class MessageKey implements Serializable {
    @Column(name = "id_user_send", nullable = false)
    private Long idUserSend;

    @Column(name = "id_message", nullable = false)
    private Long idMessage;
}
