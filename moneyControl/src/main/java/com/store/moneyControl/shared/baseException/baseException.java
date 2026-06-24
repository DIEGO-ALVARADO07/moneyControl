package com.store.moneyControl.shared.baseException;

import java.util.UUID;

public abstract class baseException extends RuntimeException{
    public baseException(Class<?> entityClass, UUID Id){
        super("!"+ entityClass.getSimpleName() + " not found: "+ Id);
    }
    
}
