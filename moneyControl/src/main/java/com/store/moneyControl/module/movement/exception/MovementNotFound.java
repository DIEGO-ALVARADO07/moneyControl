package com.store.moneyControl.module.movement.exception;

import java.util.UUID;

import com.store.moneyControl.module.movement.entity.Movement;
import com.store.moneyControl.shared.baseException.baseException;

public class MovementNotFound extends baseException{
    public MovementNotFound(UUID Id){
        super(Movement.class, Id);
    }
}
