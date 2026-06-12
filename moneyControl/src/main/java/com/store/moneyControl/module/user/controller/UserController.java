package com.store.moneyControl.module.user.controller;

import com.store.moneyControl.module.user.dto.request.UserRequest;
import com.store.moneyControl.module.user.dto.response.UserResponse;
import com.store.moneyControl.module.user.service.Implement.AUserService;
import com.store.moneyControl.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<
        UserRequest,
        UserResponse,
        UUID,
        AUserService> {
    public UserController(AUserService service){
        super(service);
    }
}
