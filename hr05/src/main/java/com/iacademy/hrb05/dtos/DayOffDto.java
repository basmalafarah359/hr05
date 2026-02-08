package com.iacademy.hrb05.dtos;

import com.iacademy.hrb05.documents.DayOff;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayOffDto {

    public DayOffDto(DayOff entity){
    this.Id = entity.getId();
    this.reason =entity.getReason();
    this.date =entity.getDate();

}

private String Id;
    @NotBlank(message = "Reason is required")
private String reason;


    @NotBlank(message = "Date is required")
private int date;

}
