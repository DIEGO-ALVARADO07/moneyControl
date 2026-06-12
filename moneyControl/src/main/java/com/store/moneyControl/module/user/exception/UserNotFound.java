package com.store.moneyControl.module.user.exception;

import java.util.UUID;

public class UserNotFound extends RuntimeException{
    public UserNotFound(UUID Id){
        super("!Person not found: "+ Id);
    }
}
