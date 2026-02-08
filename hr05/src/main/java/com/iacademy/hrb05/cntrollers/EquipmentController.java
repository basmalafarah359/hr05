package com.iacademy.hrb05.cntrollers;

import com.iacademy.hrb05.documents.Equipment;
import com.iacademy.hrb05.services.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EquipmentController {
    private final EquipmentService service;
    public EquipmentController(EquipmentService service){
        this.service=service;
    }
    @PostMapping
    public Equipment create(@RequestBody Equipment equipment) {
        return service.create(equipment);
    }
@GetMapping
    public List<Equipment>getAll(){
        return service.getAll();
}

@PutMapping("/{id}")
    public Equipment updat(@PathVariable String id,@RequestBody Equipment equipment){
        return service.update(id,equipment);
}

@DeleteMapping("/{id}")
    public void delete (@PathVariable String id){
        service.delete(id);
}










}

