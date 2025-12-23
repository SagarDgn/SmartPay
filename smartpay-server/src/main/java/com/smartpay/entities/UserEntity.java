package com.smartpay.entities;

import com.smartpay.convertor.UserRoleConvertor;
import com.smartpay.domain.USER_ROLE;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
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
    private String firstName;

    @MappedProperty("last_name")
    private String lastName;

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

    @MappedProperty(value = "user_role",converter = UserRoleConvertor.class, type = DataType.STRING)
    private USER_ROLE role= USER_ROLE.CUSTOMER;
}
