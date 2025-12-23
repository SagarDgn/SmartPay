package com.smartpay.convertor;

import com.smartpay.core.security.SecurityUtils;
import com.smartpay.domain.USER_ROLE;
import com.smartpay.entities.UserEntity;
import com.smartpay.usecase.user.add.AddUserUseCaseRequest;


public class UserConvertor {
    private UserConvertor(){}


    public static UserEntity toEntity(AddUserUseCaseRequest request){
        UserEntity userEntity= new UserEntity();
        userEntity.setFirstName(request.firstName());
        userEntity.setLastName(request.lastName());
        userEntity.setEmail(request.email());
        userEntity.setPassword(SecurityUtils.hashPassword(request.password()));
        userEntity.setRole(USER_ROLE.CUSTOMER);
        return userEntity;
    }
}
