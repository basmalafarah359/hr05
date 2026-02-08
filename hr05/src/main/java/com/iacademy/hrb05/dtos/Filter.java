package com.iacademy.hrb05.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Filter {

    private int Page = 0;
    private int size = 10;

    private String sortBY = "id";


    private Sort.Direction sortDirection = Sort.Direction.DESC;


}
