package com.iacademy.hrb05.dtos;

import com.iacademy.hrb05.documents.Equipment;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NameClassPair;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {
    public EquipmentDto(Equipment entity) {
        this.name = entity.getName();
        this.Id = entity.getId();
        this.type = entity.getType();

    }
private String Id;

@NotBlank(message = "Equipment name is required")
private String type;

@NotBlank(message = "Equipment name is required")
    private String name;

}
