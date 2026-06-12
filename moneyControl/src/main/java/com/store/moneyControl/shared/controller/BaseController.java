package com.store.moneyControl.shared.controller;

import com.store.moneyControl.shared.baseService.Interface.IBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<
        Request,
        Response,
        ID,
        Service extends IBaseService<Request, Response, ID>> {

    protected final Service service;

    protected BaseController(Service service) {
        this.service = service;
    }

    @PostMapping
    public Response create(
            @RequestBody Request request) {

        return service.Create(request);
    }

    @PutMapping("/{id}")
    public Response update(
            @PathVariable ID id,
            @RequestBody Request request) {

        return service.Update(id, request);
    }

    @GetMapping("/{id}")
    public Response getById(
            @PathVariable ID id) {

        return service.GetById(id);
    }

    @GetMapping
    public List<Response> getAll() {

        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable ID id) {

        service.Delete(id);
    }

    @PatchMapping("/{id}/soft-delete")
    public void softDelete(
            @PathVariable ID id) {

        service.SoftDelete(id);
    }
}