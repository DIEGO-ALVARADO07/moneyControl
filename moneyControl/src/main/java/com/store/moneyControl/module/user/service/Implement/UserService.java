package com.store.moneyControl.module.user.service.Implement;

import com.store.moneyControl.module.user.dto.request.UserRequest;
import com.store.moneyControl.module.user.dto.response.UserResponse;
import com.store.moneyControl.module.user.entity.User;
import com.store.moneyControl.module.user.exception.UserNotFound;
import com.store.moneyControl.module.user.mapper.UserMapper;
import com.store.moneyControl.module.user.repository.IUserRepository;
import com.store.moneyControl.module.user.service.Interface.IUserService;
import com.store.moneyControl.shared.baseService.Implement.ABaseService;


import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class UserService extends ABaseService<User,
        UserRequest,
        UserResponse,
        UUID> implements IUserService {
    public UserService(IUserRepository repository, UserMapper mapper){
        super(
                repository,
                mapper::toResponse,
                mapper::toEntity,
                mapper::updateEntity,
                UserNotFound::new
        );
    }

}
