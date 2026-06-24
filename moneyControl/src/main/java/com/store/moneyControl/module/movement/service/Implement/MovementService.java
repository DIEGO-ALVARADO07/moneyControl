package com.store.moneyControl.module.movement.service.Implement;

import com.store.moneyControl.module.movement.dto.request.MovementRequest;
import com.store.moneyControl.module.movement.dto.response.MovementResponse;
import com.store.moneyControl.module.movement.entity.Movement;
import com.store.moneyControl.module.movement.exception.MovementNotFound;
import com.store.moneyControl.module.movement.mapper.MovementMapper;
import com.store.moneyControl.module.movement.repository.IMovementRepository;
import com.store.moneyControl.module.movement.service.Interface.IMovementService;
import com.store.moneyControl.shared.baseService.Implement.ABaseService;


import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class MovementService extends ABaseService<Movement,
        MovementRequest,
        MovementResponse,
        UUID> implements IMovementService {
    public MovementService(IMovementRepository repository, MovementMapper mapper){
        super(
                repository,
                mapper::toResponse,
                mapper::toEntity,
                mapper::updateEntity,
                MovementNotFound::new
        );
    }

}
