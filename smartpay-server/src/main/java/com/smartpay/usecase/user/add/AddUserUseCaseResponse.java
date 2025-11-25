package com.smartpay.usecase.user.add;

import com.smartpay.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AddUserUseCaseResponse(
        Integer code,
        String message,
        Integer id
)
implements UseCase.Response {
}
