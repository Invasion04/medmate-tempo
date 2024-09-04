package com.dumbos.medmate.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "patients")
public class Patient {
    @Id
    private String patientId;
    private String userId; // Reference to User
    private String address;
    private List<medicalhistory> medicalHistory;


    // Getters and Setters

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<medicalhistory> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<medicalhistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }


}
