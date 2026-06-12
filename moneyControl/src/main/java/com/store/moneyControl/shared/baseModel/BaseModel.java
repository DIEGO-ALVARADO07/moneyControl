package com.store.moneyControl.shared.baseModel;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator
    protected UUID Id;

    @Column(name = "status", nullable = false)
    protected boolean Status;

    @Column(name = "createAt", nullable = false, updatable = false)
    protected LocalDateTime CreateAt;

    @Column(name = "updateAt", nullable = true)
    protected LocalDateTime UpdateAt;

    @Column(name = "deleteAt", nullable = true)
    protected LocalDateTime DeleteAt;

    @PrePersist
    protected void onCreate(){
        CreateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        UpdateAt = LocalDateTime.now();
    }

    public void onSoftDelete(){
        DeleteAt = LocalDateTime.now();
    }

}
