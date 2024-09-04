package com.dumbos.medmate.controller;

import com.dumbos.medmate.model.medicalhistory;
import com.dumbos.medmate.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical_histories")
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping
    public List<medicalhistory> getAllMedicalHistories() {
        return medicalHistoryService.getAllMedicalHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<medicalhistory> getMedicalHistoryById(@PathVariable String id) {
        Optional<medicalhistory> medicalHistory = medicalHistoryService.getMedicalHistoryById(id);
        return medicalHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public medicalhistory createMedicalHistory(@RequestBody medicalhistory medicalHistory) {
        return medicalHistoryService.saveMedicalHistory(medicalHistory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<medicalhistory> updateMedicalHistory(@PathVariable String id, @RequestBody medicalhistory medicalHistory) {
        if (medicalHistoryService.getMedicalHistoryById(id).isPresent()) {
            medicalHistory.setRecordId(id);
            return ResponseEntity.ok(medicalHistoryService.saveMedicalHistory(medicalHistory));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable String id) {
        if (medicalHistoryService.getMedicalHistoryById(id).isPresent()) {
            medicalHistoryService.deleteMedicalHistory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
