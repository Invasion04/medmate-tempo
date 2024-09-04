package com.dumbos.medmate.service;

import com.dumbos.medmate.model.Patient;
import com.dumbos.medmate.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String patientId) {
        return patientRepository.findById(patientId);
    }

    public Patient updatePatient(String patientId, Patient patient) {
        if (patientRepository.existsById(patientId)) {
            patient.setPatientId(patientId);
            return patientRepository.save(patient);
        }
        return null;
    }

    public void deletePatient(String patientId) {
        patientRepository.deleteById(patientId);
    }

    public Patient getPatientByUserId(String userId) {
        return patientRepository.findByUserId(userId);
    }
}
