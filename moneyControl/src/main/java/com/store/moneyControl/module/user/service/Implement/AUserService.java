package com.store.moneyControl.module.user.service.Implement;

import com.store.moneyControl.module.user.dto.request.UserRequest;
import com.store.moneyControl.module.user.dto.response.UserResponse;
import com.store.moneyControl.module.user.entity.User;
import com.store.moneyControl.module.user.exception.UserNotFound;
import com.store.moneyControl.module.user.mapper.UserMapper;
import com.store.moneyControl.module.user.repository.IUserRepository;
import com.store.moneyControl.module.user.service.Interface.IUserService;
import com.store.moneyControl.shared.baseService.Implement.ABaseService;
import com.store.moneyControl.shared.baseService.Interface.IBaseService;

import java.util.UUID;

public abstract class AUserService extends ABaseService<User,
        UserRequest,
        UserResponse,
        UUID> implements IUserService {
    public AUserService(IUserRepository repository, UserMapper mapper){
        super(
                repository,
                mapper::toResponse,
                mapper::toEntity,
                mapper::updateEntity,
                UserNotFound::new
        );
    }

}
