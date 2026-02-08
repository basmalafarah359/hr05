package com.iacademy.hrb05.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResult{

    private Collection<?> data;
    private int page;
    private int size;
    private long totalElements;









}
