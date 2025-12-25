package com.smartpay.domain.convertor;

import com.smartpay.domain.USER_ROLE;
import io.micronaut.core.convert.ConversionContext;
import io.micronaut.data.model.runtime.convert.AttributeConverter;
import jakarta.inject.Singleton;

@Singleton
public class UserRoleConvertor implements AttributeConverter<USER_ROLE, String> {


    @Override
    public  String convertToPersistedValue(USER_ROLE entityValue, ConversionContext context) {
        return entityValue == null ? null : entityValue.name();
    }

    @Override
    public USER_ROLE convertToEntityValue(String datastoreValue, ConversionContext context) {
        return datastoreValue == null ? null : USER_ROLE.valueOf(datastoreValue);
    }
}
