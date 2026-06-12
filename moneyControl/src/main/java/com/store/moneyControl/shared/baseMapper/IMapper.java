package com.store.moneyControl.shared.baseMapper;

import org.mapstruct.MappingTarget;

public interface IMapper<Entity,
        Request,
        Response>
{
    Entity toEntity(Request request);

    Response toResponse(Entity entity);

    void updateEntity(
            Request request,
            @MappingTarget Entity entity);
}
