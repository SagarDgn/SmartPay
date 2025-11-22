package com.smartpay.entities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@MappedEntity("users_data")
@Serdeable
@Introspected
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @MappedProperty("user_id")
    private Integer id;

    @MappedProperty("first_name")
    private String first_name;

    @MappedProperty("last_name")
    private String last_name;

    @MappedProperty("email")
    private String email;

    @MappedProperty("password")
    private String password;

    @DateCreated
    @MappedProperty("creation_date")
    private Instant createdAt;

    @DateUpdated
    @MappedProperty("updated_date")
    private Instant updatedDate;
}
