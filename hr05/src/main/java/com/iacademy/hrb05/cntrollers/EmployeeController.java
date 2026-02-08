package com.iacademy.hrb05.cntrollers;

import com.iacademy.hrb05.dtos.EmployeeDto;
import com.iacademy.hrb05.dtos.EmployeeFilter;
import com.iacademy.hrb05.documents.Employee;
import com.iacademy.hrb05.dtos.PageResult;
import com.iacademy.hrb05.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeServices service;

    public EmployeeController(EmployeeServices services) {
        this.service = services;

    }

    @PostMapping
    public EmployeeDto create(@RequestBody @Valid EmployeeDto entity) {

        return service.create(entity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody EmployeeDto emp) {

        service.update(id, emp);
    }

    @GetMapping("/get-by-id/{id}")
    public EmployeeDto getByID(@PathVariable String id) {
        return service.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String ID) {
        service.delete(ID);
    }

    @GetMapping("/search")
    public PageResult Search(EmployeeFilter filter) {
        return service.search(filter);
    }
}
