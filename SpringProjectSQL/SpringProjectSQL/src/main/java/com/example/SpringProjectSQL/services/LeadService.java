package com.example.SpringProjectSQL.services;

import com.example.SpringProjectSQL.Repository.LeadRepository;
import com.example.SpringProjectSQL.Repository.SubmissionRepository;
import com.example.SpringProjectSQL.model.Lead;
import com.example.SpringProjectSQL.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LeadService {


    @Autowired
    private LeadRepository leadRepository;

    public Lead addLead(Lead lead) {

        return leadRepository.save(lead);
    }



    public List<Lead> getAllLeads() {
        return  leadRepository.findAll();
    }

    public String  deleteLead(int id) {
        leadRepository.deleteById(id);
        return "Success";
    }

    public Lead getLeadById(int id) {

        return leadRepository.findById(id).get();
    }




    public Lead editLead(int id,Lead leadDetails) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        lead.setId(leadDetails.getId());
        lead.setFirst_name(leadDetails.getFirst_name());
        lead.setLast_name(leadDetails.getLast_name());
        lead.setEmail_address(leadDetails.getEmail_address());
        lead.setPhone_number(leadDetails.getPhone_number());

        return lead;

    }





}
