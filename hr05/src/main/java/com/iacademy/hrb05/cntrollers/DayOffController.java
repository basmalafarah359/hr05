package com.iacademy.hrb05.cntrollers;

import com.iacademy.hrb05.documents.DayOff;
import com.iacademy.hrb05.services.DayOffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dayoff")
public class DayOffController {
private final DayOffService service;



public DayOffController( DayOffService service){
    this.service = service;
}

@PostMapping
    public DayOff creat(@RequestBody DayOff dayOff){
    return service.creat(dayOff);
}

    @GetMapping
    public List<DayOff> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public DayOff update(@PathVariable String id,
                         @RequestBody DayOff dayOff) {
        return service.update(id, dayOff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }







}


