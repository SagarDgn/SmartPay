package com.smartpay.convertor;

import com.smartpay.core.security.SecurityUtils;
import com.smartpay.domain.USER_ROLE;
import com.smartpay.entities.UserEntity;
import com.smartpay.usecase.user.add.AddUserUseCaseRequest;


public class UserConvertor {
    private UserConvertor(){}


    public static UserEntity toEntity(AddUserUseCaseRequest request){
        UserEntity userEntity= new UserEntity();
        userEntity.setFirst_name(request.first_name());
        userEntity.setLast_name(request.last_name());
        userEntity.setEmail(request.email());
        userEntity.setPassword(SecurityUtils.hashPassword(request.password()));
        userEntity.setRole(USER_ROLE.valueOf("CUSTOMER"));
        return userEntity;
    }
}
