package com.store.moneyControl.shared.baseService.Interface;



import java.util.List;

public interface IBaseService<Request, Response, Id> {
    List<Response> findAll();
    Response GetById(Id id);
    Response Create(Request request);
    Response Update(Id id, Request request);
    boolean SoftDelete(Id id);
    void Delete(Id id);


}
