package com.messager.model.domain.conversation;

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
public class ConversationKey implements Serializable {

    @Column(name = "id_conversation", nullable = false)
    private Long idConversation;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

}
