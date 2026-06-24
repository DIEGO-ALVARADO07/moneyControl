package com.store.moneyControl.module.movement.controller;

import com.store.moneyControl.module.movement.dto.request.MovementRequest;
import com.store.moneyControl.module.movement.dto.response.MovementResponse;
import com.store.moneyControl.module.movement.service.Implement.MovementService;
import com.store.moneyControl.shared.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/movement")
public class MovementController extends BaseController<
        MovementRequest,
        MovementResponse,
        UUID,
        MovementService> {
    public MovementController(MovementService service){
        super(service);
    }
}
