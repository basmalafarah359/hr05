package com.iacademy.hrb05.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document


public class Employee {
    @Id
    private String id;

    private String name;

    private String title;

    private Date dob;

    private Double salary;

    private Date hiringDate;


}
