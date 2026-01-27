package com.iacademy.hrb05.repositories;

import com.iacademy.hrb05.documents.DayOff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DayOffRepository extends MongoRepository<DayOff,String> {
}
