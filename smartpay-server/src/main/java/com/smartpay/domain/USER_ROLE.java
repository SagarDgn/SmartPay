package com.smartpay.domain;

import io.micronaut.context.annotation.Bean;
import io.micronaut.core.convert.ConversionContext;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import io.micronaut.data.model.runtime.convert.AttributeConverter;
import jakarta.inject.Singleton;


public enum USER_ROLE {
    CUSTOMER,
    ADMIN;

}
