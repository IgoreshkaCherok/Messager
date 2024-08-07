package com.messager.model.domain.friend;

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
public class FriendKey implements Serializable {
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "id_signed", nullable = false)
    private Long idSigned;
}
