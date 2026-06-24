package com.store.moneyControl.module.movement.service.Interface;

import com.store.moneyControl.module.movement.dto.request.MovementRequest;
import com.store.moneyControl.module.movement.dto.response.MovementResponse;
import com.store.moneyControl.shared.baseService.Interface.IBaseService;

import java.util.UUID;

public interface IMovementService
        extends IBaseService<
        MovementRequest,
        MovementResponse,
        UUID> {
}
