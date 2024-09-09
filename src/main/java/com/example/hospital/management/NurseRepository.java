package com.example.hospital.management;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

// in this class we will contain the database(HashMap, sql)
@Repository
public class NurseRepository {

    HashMap<Integer,Nurse> nurseDb = new HashMap<>();

    public String addNurse(Nurse nurse) {

        int key = nurse.getNurseId();
        nurseDb.put(key,nurse);
        return "Nurse added Successfully";
    }

    public List<Nurse> getAllNurses() {
        return nurseDb.values().stream().toList();
    }
}
