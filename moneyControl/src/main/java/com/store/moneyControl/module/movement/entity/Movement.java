package com.store.moneyControl.module.movement.entity;

import com.store.moneyControl.shared.baseModel.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(length = 50, nullable = false)
    protected String UserName;
    
    @Column(length = 50, nullable = false)
    protected String Password;
}
