package com.store.moneyControl.module.user.exception;

import java.util.UUID;

import com.store.moneyControl.module.user.entity.User;
import com.store.moneyControl.shared.baseException.baseException;

public class UserNotFound extends baseException{
    public UserNotFound(UUID Id){
        super(User.class, Id);
    }
}
