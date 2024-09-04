package com.dumbos.medmate.service;

import com.dumbos.medmate.model.medicalhistory;
import com.dumbos.medmate.Repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryService {
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    public List<medicalhistory> getAllMedicalHistories() {
        return medicalHistoryRepository.findAll();
    }

    public Optional<medicalhistory> getMedicalHistoryById(String recordId) {
        return medicalHistoryRepository.findById(recordId);
    }

    public medicalhistory saveMedicalHistory(medicalhistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    public void deleteMedicalHistory(String recordId) {
        medicalHistoryRepository.deleteById(recordId);
    }
}
