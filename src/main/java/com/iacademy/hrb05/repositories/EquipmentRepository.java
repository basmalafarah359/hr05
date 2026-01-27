package com.iacademy.hrb05.repositories;

import com.iacademy.hrb05.documents.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepository extends MongoRepository<Equipment,String> {
}


