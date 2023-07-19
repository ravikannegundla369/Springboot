package com.example.SpringProjectSQL.services;

import com.example.SpringProjectSQL.Repository.ConsultantRepository;
import com.example.SpringProjectSQL.Repository.LeadRepository;
import com.example.SpringProjectSQL.model.Consultant;
import com.example.SpringProjectSQL.model.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;


    public Consultant addConsultant(Consultant consultant) {

        return consultantRepository.save(consultant);
    }


    public List<Consultant> getAllConsultants() {
        return  consultantRepository.findAll();
    }

    public String  deleteConsultant(int id) {
        consultantRepository.deleteById(id);
        return "Success";
    }


    public Consultant getConsultantById(int id) {

        return consultantRepository.findById(id).get();
    }



    public Consultant editConsultant(int id,Consultant consultantdetails) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        consultant.setConsultant_id(consultantdetails.getConsultant_id());
        consultant.setFirst_name(consultantdetails.getFirst_name());
        consultant.setLast_name(consultantdetails.getLast_name());
        consultant.setEmail_address(consultantdetails.getEmail_address());
        consultant.setPhone_number(consultantdetails.getPhone_number());

        return consultant;

    }








    }
