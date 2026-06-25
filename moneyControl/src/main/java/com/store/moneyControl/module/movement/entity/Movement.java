package com.store.moneyControl.module.movement.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.store.moneyControl.shared.baseModel.BaseModel;
import com.store.moneyControl.module.movement.Enum.MovementType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "movement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movement extends BaseModel {
    @Column(precision = 15, scale = 2, nullable = false)
    protected BigDecimal Amount;

    @Enumerated(EnumType.ORDINAL) // Save a value in mysql
    @Column(nullable = false)
    protected MovementType MovementType;

    @Column(length = 255, nullable = false)
    protected String Description;

    @Column(nullable = false)
    protected LocalDateTime MovementDate;
}
