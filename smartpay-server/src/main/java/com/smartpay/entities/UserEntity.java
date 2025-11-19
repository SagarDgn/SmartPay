package com.smartpay.entities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

@Entity
@Table(name = "users_data")
@Serdeable
@Introspected
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
}
