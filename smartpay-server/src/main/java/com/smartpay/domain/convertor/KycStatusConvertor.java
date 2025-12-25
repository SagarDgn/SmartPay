package com.smartpay.domain.convertor;

import com.smartpay.domain.KYC_STATUS;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.convert.ConversionContext;
import io.micronaut.data.model.runtime.convert.AttributeConverter;

public class KycStatusConvertor implements AttributeConverter<KYC_STATUS,String> {

    @Override
    public String convertToPersistedValue(KYC_STATUS entityValue, @NonNull ConversionContext context) {
        return entityValue== null ?null : entityValue.name();
    }

    @Override
    public @Nullable KYC_STATUS convertToEntityValue(@Nullable String persistedValue, @NonNull ConversionContext context) {
        return persistedValue== null ?null : KYC_STATUS.valueOf(persistedValue);
    }

}
