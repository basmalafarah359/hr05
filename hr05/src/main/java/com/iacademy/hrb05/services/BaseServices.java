package com.iacademy.hrb05.services;

import com.iacademy.hrb05.dtos.Filter;
import com.iacademy.hrb05.dtos.PageResult;

import java.util.List;

public interface BaseServices<Dto,ID, RequestFilter extends Filter> {



    Dto create(Dto entity);
    Dto getByID(ID id);
    void update(ID id, Dto entity);
    void delete(ID id);
   List<Dto> getAll();

   PageResult search(RequestFilter filter );


}
