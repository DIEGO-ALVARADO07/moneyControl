package com.store.moneyControl.module.user.mapper;

import com.store.moneyControl.module.user.dto.request.UserRequest;
import com.store.moneyControl.module.user.dto.response.UserResponse;
import com.store.moneyControl.module.user.entity.User;
import com.store.moneyControl.shared.baseMapper.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
        extends IMapper<
        User,
        UserRequest,
        UserResponse> {
}
