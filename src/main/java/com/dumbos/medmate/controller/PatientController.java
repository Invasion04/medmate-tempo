package com.dumbos.medmate.controller;

import com.dumbos.medmate.model.Patient;
import com.dumbos.medmate.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String patientId) {
        Optional<Patient> patient = patientService.getPatientById(patientId);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String patientId, @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(patientId, patient);
        return updatedPatient != null ? new ResponseEntity<>(updatedPatient, HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable String patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Patient> getPatientByUserId(@PathVariable String userId) {
        Patient patient = patientService.getPatientByUserId(userId);
        return patient != null ? new ResponseEntity<>(patient, HttpStatus.OK) : ResponseEntity.notFound().build();
    }
}
