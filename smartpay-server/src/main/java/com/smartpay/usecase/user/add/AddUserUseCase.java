package com.smartpay.usecase.user.add;

import com.smartpay.convertor.UserConvertor;
import com.smartpay.core.usecase.UseCase;
import com.smartpay.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class AddUserUseCase implements UseCase<AddUserUseCaseRequest,AddUserUseCaseResponse> {

    public final UserRepository userRepository;

    @Inject
    public AddUserUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public Mono<AddUserUseCaseResponse> execute(AddUserUseCaseRequest request) {
        var userEntity= UserConvertor.toEntity(request);
        return userRepository.save(userEntity)
                .map(userData -> new AddUserUseCaseResponse(1,"User added successfully", userData.getId()))
                .onErrorResume(err->Mono.error(new Throwable("Error on adding user"+err.getLocalizedMessage())));
    }
}
