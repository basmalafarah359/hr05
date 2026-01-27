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
        return repository.save(dayOff);
    }

    public List<DayOff> getAll() {
        return repository.findAll();
    }

    public DayOff update(String id, DayOff dayOff) {
        DayOff old = repository.findById(id).orElseThrow();
        old.setReason(dayOff.getReason());
        old.setDate(dayOff.getDate());
        return repository.save(old);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    {


        if (dayOffRepository.existsByDate(dto.getDate()))

            throw new RuntimeException("Day off already exists for this date");
    }


}

    

