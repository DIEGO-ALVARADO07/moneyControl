package com.store.moneyControl.shared.baseService.Implement;

import com.store.moneyControl.shared.baseModel.BaseModel;
import com.store.moneyControl.shared.baseService.Interface.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class ABaseService<Entity extends BaseModel,
        Request,
        Response,
        Id>
        implements IBaseService<Request, Response, Id> {

    private final JpaRepository<Entity, Id> repository;
    private final Function<Entity, Response> toResponse;
    private final Function<Request, Entity> toEntity;
    private final BiConsumer<Request, Entity> updateEntity;
    private final Function<Id, RuntimeException> notFound;

    protected ABaseService(
            JpaRepository<Entity, Id> repository,
            Function<Entity, Response> toResponse,
            Function<Request, Entity> toEntity,
            BiConsumer<Request, Entity> updateEntity,
            Function<Id, RuntimeException> notFound) {

        this.repository = repository;
        this.toResponse = toResponse;
        this.toEntity = toEntity;
        this.updateEntity = updateEntity;
        this.notFound = notFound;
    }


    @Override
    public List<Response> findAll() {

        return repository.findAll()
                .stream()
                .map(toResponse)
                .toList();
    }

    @Override
    public Response GetById(Id id) {

        Entity entity = repository.findById(id)
                .orElseThrow(() -> notFound.apply(id));

        return toResponse.apply(entity);
    }

    @Override
    public Response Create(Request request) {

        Entity entity = toEntity.apply(request);

        repository.save(entity);

        return toResponse.apply(entity);
    }

    @Override
    public Response Update(Id id, Request request) {

        Entity entity = repository.findById(id)
                .orElseThrow(() -> notFound.apply(id));

        updateEntity.accept(request, entity);

        repository.save(entity);

        return toResponse.apply(entity);
    }


    @Override
    public boolean SoftDelete(Id id) {

        Entity entity = repository.findById(id)
                .orElseThrow(() -> notFound.apply(id));

        entity.onSoftDelete();

        repository.save(entity);
        return false;
    }

    @Override
    public void Delete(Id id) {

        Entity entity = repository.findById(id)
                .orElseThrow(() -> notFound.apply(id));

        repository.delete(entity);
    }
}
