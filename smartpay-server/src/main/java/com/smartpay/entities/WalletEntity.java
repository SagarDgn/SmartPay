package com.smartpay.entities;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.*;
import io.micronaut.data.annotation.sql.JoinColumn;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@MappedEntity
@Serdeable
@Introspected
@Getter
@Setter
public class WalletEntity {

    @Id
    @GeneratedValue
    @MappedProperty("wallet_id")
    private Integer id;

    @JoinColumn(name = "user")
    @Relation(Relation.Kind.MANY_TO_ONE)
    private UserEntity userEntity;

    @MappedProperty("user_balance")
    private BigDecimal balance;
}
