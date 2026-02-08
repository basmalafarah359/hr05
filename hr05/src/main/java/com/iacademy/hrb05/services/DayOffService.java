package com.iacademy.hrb05.services;

import com.iacademy.hrb05.documents.DayOff;
import com.iacademy.hrb05.repositories.DayOffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayOffService {
    private DayOffRepository repository;

    public void DayOffService(DayOffRepository repository) {
        this.repository = repository;
    }

    public DayOff create(DayOff dayOff) {
        if (repository.existsByDate(
                dayOff.getEmployeeId(),
                dayOff.getDate())) {
            throw new RuntimeException("Employee already has a day off on this date");
        }
return repository.save(dayOff);






    }

    public List<DayOff> getAll() {
        return repository.findAll();
    }

    public DayOff update(String id, DayOff dayOff) {
        DayOff old = repository.findById(id).orElseThrow();
        repository.findByEmployeeIdAndDate(
                dayOff.getEmployeeId(),
                dayOff.getDate()
        ).ifPresent(existing -> {
            if (!existing.getId().equals(id)) {
                throw new RuntimeException(
                        "Employee already has a day off on this date"
                );
            }
        });

    
        old.setReason(dayOff.getReason());
        old.setDate(dayOff.getDate());
        return repository.save(old);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    public DayOff creat(DayOff dayOff) {
    }
}






    

