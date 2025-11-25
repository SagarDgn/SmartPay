package com.smartpay.domain;

import io.micronaut.core.convert.ConversionContext;
import io.micronaut.data.model.runtime.convert.AttributeConverter;

public enum USER_ROLE {
    CUSTOMER,
    ADMIN;

    public static class Converter implements AttributeConverter<USER_ROLE, String> {

        @Override
        public String convertToPersistedValue(USER_ROLE entityValue, ConversionContext context) {
            return entityValue == null ? null : entityValue.name();
        }

        @Override
        public USER_ROLE convertToEntityValue(String datastoreValue, ConversionContext context) {
            return datastoreValue == null ? null : USER_ROLE.valueOf(datastoreValue);
        }
    }
}
