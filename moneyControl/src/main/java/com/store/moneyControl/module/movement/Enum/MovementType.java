package com.store.moneyControl.module.movement.Enum;

public enum MovementType {
    INCOME(1),
    EXPENSE(2);

    protected final int Id;

    MovementType(int id) {
        this.Id = id;
    }

    public int getId() {
        return Id;
    }
}
