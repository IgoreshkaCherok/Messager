package com.messager.model.domain.messages;

import com.messager.model.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "messages_many_to_many")
public class MessageMany {
    @EmbeddedId
    private MessageKey messageKey;

    @MapsId("idUserSend")
    @ManyToOne
    @JoinColumn(name = "id_user_send", insertable = false, updatable = false)
    private User user;

    @MapsId("idMessage")
    @ManyToOne
    @JoinColumn(name = "id_message", insertable = false, updatable = false)
    private Message message;

}
