package com.store.moneyControl.module.movement.repository;

import com.store.moneyControl.module.movement.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IMovementRepository extends JpaRepository<Movement, UUID> {
}
