package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    HashMap<Integer, Patient> patientDb = new HashMap<>();
    @PostMapping("/addPatientViaParams")
    public String  addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("patientName")String patientName,
                           @RequestParam("disease")String  disease, @RequestParam("age")Integer age) {


        Patient patient = new Patient(patientId, patientName, disease, age);

        patientDb.put(patientId,patient);
        return "Patient Added Successfully";
    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        patientDb.put(key,patient);

        return "Patient added Successfully";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatientInfo(@RequestParam("patientId")Integer patientId) {

        Patient patientInfo = patientDb.get(patientId);
        return patientInfo;
    }

        @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        for(Patient p: patientDb.values()) {
            patients.add(p);
        }

        return patients;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("patientName")String patientName)   {

        for(Patient p: patientDb.values()) {
            if(p.getPatientName().equals(patientName)) {
                return p;
            }
        }
        return  null;
    }

    @GetMapping("/getPatientListGreaterThanAge")
    public List<Patient> getPatientListGreaterThanAge(@RequestParam("age")Integer age) {

        List<Patient> ageList = new ArrayList<>();

        for(Patient p: patientDb.values()) {
            if (p.getAge() > age) {
                ageList.add(p);
            }
        }

        return ageList;
    }

    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getInfoViaPathVariable(@PathVariable("patientId")Integer patientId){

        Patient patient = patientDb.get(patientId);

        return patient;
    }

    @GetMapping("/getInfoViaTwoPathVariable/{age}/{disease}")
    public List<Patient> getInfoViaTwoPathVariable(@PathVariable("age")Integer age, @PathVariable("disease")String disease){

        List<Patient> patients = new ArrayList<>();
        for(Patient p: patientDb.values()) {
            if(p.getAge() > age && p.getDiseas().equals(disease)) {
                patients.add(p);
            }
        }
//        Patient patient = patientDb.get(patientId);

        return patients;
    }

    @PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient) {

        int key = patient.getPatientId();

        if(patientDb.containsKey(key)) {
            patientDb.put(key,patient);
            return "Updated Patient Details Successfully";
        } else {
            return "Patient does not exist";
        }
    }

    @PutMapping("/udateDisease")
    public String updateDisease(@RequestParam("patientId")Integer patientId, @RequestParam("disease")String disease) {
        if(patientDb.containsKey(patientId)) {
            Patient patient = patientDb.get(patientId);
            patient.setDiseas(disease);
            patientDb.put(patientId,patient);
            return "Disease Updated Successfully!";
        } else {
            return "Patient Not found";
        }
    }

    @DeleteMapping("/deletePatient/{patientId}")
    public String deletePatient(@PathVariable("patientId")Integer patientId) {

        if(patientDb.containsKey(patientId)) {
            patientDb.remove(patientId);
            return "Patient Deleted Successfully";
        }
        return "patient not found....";
    }
}
