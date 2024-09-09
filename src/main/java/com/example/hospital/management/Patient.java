package com.example.hospital.management;

public class Patient {

    private int patientId;
    private String patientName;
    private String disease;
    private int age;

    public Patient(int patientId, String patientName, String disease, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.disease = disease;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiseas() {
        return disease;
    }

    public void setDiseas(String diseas) {
        this.disease = diseas;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
