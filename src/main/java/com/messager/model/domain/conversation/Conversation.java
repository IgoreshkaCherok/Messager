package com.messager.model.domain.conversation;

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
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conversation")
    private Long idConversation;

    @Column(name = "name_conversation")
    private String nameConversation;

    @Column(name = "group_true")
    private boolean groupTrue;

}
