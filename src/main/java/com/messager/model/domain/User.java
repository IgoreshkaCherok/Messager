package com.messager.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "placeofbirth", nullable = false)
    private String placeOfBirth;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "telephone", nullable = false)
    private String telephone;
}
