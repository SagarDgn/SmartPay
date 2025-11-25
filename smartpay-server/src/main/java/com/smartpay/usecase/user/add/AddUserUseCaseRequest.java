package com.smartpay.usecase.user.add;

import com.smartpay.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
public record AddUserUseCaseRequest(
        @NotBlank(message = "First name is required")
        String first_name,
        @NotBlank(message = "Last name is required")
        String last_name,
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "passowrd is required")
        String password
)
implements UseCase.Request {
}
