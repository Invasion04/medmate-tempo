package com.dumbos.medmate.Repository;

import com.dumbos.medmate.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient findByUserId(String userId);
}
