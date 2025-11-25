package com.smartpay.controllers;

import com.smartpay.core.response.RestResponse;
import com.smartpay.usecase.user.add.AddUserUseCase;
import com.smartpay.usecase.user.add.AddUserUseCaseRequest;
import com.smartpay.usecase.user.add.AddUserUseCaseResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@Controller("/api/v1")
public class UserController {

    public final AddUserUseCase addUserUseCase;

    @Inject
    public UserController(AddUserUseCase addUserUseCase){
        this.addUserUseCase=addUserUseCase;
    }

    @Post("/user")
    public Mono<RestResponse<AddUserUseCaseResponse>> addUser(@Body AddUserUseCaseRequest request){
        return addUserUseCase.execute(request)
                .map(RestResponse::success)
                .onErrorResume(err->Mono.just(RestResponse.error(err.getLocalizedMessage())));
    }
}
