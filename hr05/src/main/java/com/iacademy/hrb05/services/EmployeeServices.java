package com.iacademy.hrb05.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iacademy.hrb05.dtos.EmployeeDto;
import com.iacademy.hrb05.dtos.EmployeeFilter;
import com.iacademy.hrb05.documents.Employee;
import com.iacademy.hrb05.dtos.Filter;
import com.iacademy.hrb05.dtos.PageResult;
import com.iacademy.hrb05.exception.CustomException;
import com.iacademy.hrb05.repositories.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServices implements BaseServices<EmployeeDto, String, EmployeeFilter> {
    private EmployeeRepository repository;
    private MongoTemplate template;
    private ObjectMapper mapper;

    public EmployeeServices(EmployeeRepository repository, MongoTemplate template) {
        this.repository = repository;
        this.template = template;
    }


    @Override
    public EmployeeDto create(EmployeeDto employee) {
        return mapper.convertValue(repository.save(mapper.convertValue(employee, Employee.class)), EmployeeDto.class);
    }

    @Override
    public EmployeeDto getByID(String s) {
        return
                mapper.convertValue(read(s), EmployeeDto.class);
    }

    private Employee read(String s) {
        return repository.findById(s).orElseThrow(
                () -> new CustomException("employee not found", HttpStatus.NOT_FOUND));
    }


    @Override
    public void update(String s, EmployeeDto employee) {
        Employee entity = read(s);
        entity.setSalary(employee.getSalary());
        entity.setTitle(employee.getTitle());
        repository.save(entity);
    }


    @Override
    public void delete(String s) {
        repository.deleteById(s);


    }

    @Override
    public List<EmployeeDto> getAll() {

//        return repository.findAll().stream();
        return null;
    }

    public PageResult search(EmployeeFilter filter) {
        Query query = new Query();
        if (filter.getKey() != null && !filter.getKey().isBlank()) {

            query.addCriteria(
                    new Criteria().orOperator(
                            Criteria.where("name").regex(filter.getKey(), "i"),
                            Criteria.where("email").regex(filter.getKey(), "i")

                    )
            );
        }

        if (filter.getMaxSalary() != null && filter.getMinSalary() != null) {
            query.addCriteria(
                    Criteria.where("salary").lte(filter.getMaxSalary()).gte(filter.getMinSalary())


            );
        } else if (filter.getMinSalary() != null) {

            query.addCriteria(
                    Criteria.where("salary")
                            .gte(filter.getMinSalary()
                            ));
        } else if (filter.getMaxSalary() != null) {

            query.addCriteria(
                    Criteria.where("salary")
                            .lte(filter.getMaxSalary())
            );
        }

        long count = template.count(query, Employee.class);/// TODO: convert to EmployeeDto

        // create pageable
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize(), Sort.by(filter.getSortDirection(), filter.getSortBY()));

        //query with pageable
        query.with(pageable);


        List<Employee> data = template.find(query, Employee.class);/// TODO: convert to EmployeeDto

        //return pageResult
        return PageResult.builder()
                .data(data)
                .totalElements(count)
                .build();

    }


}

