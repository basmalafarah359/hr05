package com.iacademy.hrb05.repositories;

import com.iacademy.hrb05.documents.DayOff;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DayOffRepository extends MongoRepository<DayOff,String> {

    boolean existsByDate(String employeeId, int date);

    Optional<DayOff> findByEmployeeIdAndDate(String employeeId, int date);
}
