package com.iacademy.hrb05.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String title;
    @NotNull
    @Past
    private Date dob;
    @NotNull
    @DecimalMin(value = "1.0")
    private Double salary;
    @PastOrPresent
    @NotNull
    private Date hiringDate;
}
