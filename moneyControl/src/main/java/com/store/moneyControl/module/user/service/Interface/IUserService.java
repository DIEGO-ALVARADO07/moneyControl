package com.store.moneyControl.module.user.service.Interface;

import com.store.moneyControl.module.user.dto.request.UserRequest;
import com.store.moneyControl.module.user.dto.response.UserResponse;
import com.store.moneyControl.shared.baseService.Interface.IBaseService;

import java.util.UUID;

public interface IUserService
        extends IBaseService<
        UserRequest,
        UserResponse,
        UUID> {
}
