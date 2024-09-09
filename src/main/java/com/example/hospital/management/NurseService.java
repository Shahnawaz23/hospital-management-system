package com.example.hospital.management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//in service layer we write logic, validation, etc.
@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse) {

        //we should write some logic here
        if(nurse.getNurseId()<0) {
            return "Enter valid nurse ID";
        }

        if(nurse.getName().equals(null)) {
            return "Nurse Name should not be null";
        }

        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }


    //calling all the nurses from the database,hashmap
    public List<Nurse> getList(Integer age) {

        List<Nurse> nurses = nurseRepository.getAllNurses();

        List<Nurse> finalList = new ArrayList<>();

        for(Nurse nurse : nurses) {
            if(nurse.getAge()> age) {
                finalList.add(nurse);
            }
        }
        return finalList;
    }

    public List<Nurse> getNurseWithQualification(String qualification) {

        List<Nurse> nurses = nurseRepository.getAllNurses();
        List<Nurse> qualificationList = new ArrayList<>();

        for (Nurse nurse: nurses) {
            if(nurse.getQualification().equals(qualification)) {
                qualificationList.add(nurse);
            }
        }

        return qualificationList;
    }
}
