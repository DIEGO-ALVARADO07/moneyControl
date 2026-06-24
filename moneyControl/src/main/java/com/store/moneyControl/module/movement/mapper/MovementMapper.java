package com.store.moneyControl.module.movement.mapper;

import com.store.moneyControl.module.movement.dto.request.MovementRequest;
import com.store.moneyControl.module.movement.dto.response.MovementResponse;
import com.store.moneyControl.module.movement.entity.Movement;
import com.store.moneyControl.shared.baseMapper.IMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementMapper
        extends IMapper<
        Movement,
        MovementRequest,
        MovementResponse> {
}
