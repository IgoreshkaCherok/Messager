package com.messager.model.domain.conversation;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "conversation_many_to_many")
public class ConversationMany {
    @EmbeddedId
    private ConversationKey conversationKey;

    @MapsId("idConversation")
    @ManyToOne
    @JoinColumn(name = "id_conversation", insertable = false, updatable = false)
    private Conversation conversation;

    @MapsId("idUser")
    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name = "user_reporter", nullable = false)
    private boolean userReporter;
}
