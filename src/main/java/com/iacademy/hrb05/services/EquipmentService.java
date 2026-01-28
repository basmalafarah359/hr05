package com.iacademy.hrb05.services;

import com.iacademy.hrb05.documents.Equipment;
import com.iacademy.hrb05.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.security.cert.X509CRLEntry;
import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository repository;


    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;

    }

    public Equipment create(Equipment equipment) {
        if (repository.existsById(equipment.getId())){
            throw new RuntimeException("This id already exists");
        }
        return repository.save(equipment);


    }


    public List<Equipment> getAll() {
        return repository.findAll();
    }

    public Equipment update(String id, Equipment equipment) {
        if (repository.existsById(id)){
            throw new RuntimeException("Equipment not found with this id");
        }
        Equipment old = repository.findById(id).orElseThrow();
        old.setName(equipment.getName());
        old.setType(equipment.getType());
        return repository.save(old);
    }

    public void delete(String id) {
        if (repository.existsById(id)){
            throw new RuntimeException("Equipment not found with this id");
        }
        repository.deleteById(id);
    }
}


























