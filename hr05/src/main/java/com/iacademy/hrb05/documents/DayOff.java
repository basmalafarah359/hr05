package com.iacademy.hrb05.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class DayOff {


    @Id
    private String id;
    private String reason;
    private int date;


   private String employeeid;

    public String getEmployeeId() {
        return null;
    }
}

