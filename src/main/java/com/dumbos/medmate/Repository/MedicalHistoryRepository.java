package com.dumbos.medmate.Repository;

import com.dumbos.medmate.model.medicalhistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends MongoRepository<medicalhistory, String> {
    // Custom query methods (if needed)
}
