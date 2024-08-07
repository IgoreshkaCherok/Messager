package com.messager.model.domain.friend;

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
@Table(name = "friends")
public class Friend {
    @EmbeddedId
    private FriendKey friendKey;

    @Column(name = "mutually_signed", nullable = false)
    private boolean mutuallySigned;
}
