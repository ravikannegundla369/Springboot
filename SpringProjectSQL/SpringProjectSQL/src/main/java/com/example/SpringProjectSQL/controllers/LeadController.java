package com.example.SpringProjectSQL.controllers;

import com.example.SpringProjectSQL.model.Lead;
import com.example.SpringProjectSQL.model.Submission;
import com.example.SpringProjectSQL.services.LeadService;
import com.example.SpringProjectSQL.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lead")

public class LeadController {


    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead addLead(@RequestBody Lead lead){
        return leadService.addLead(lead);

    }
    @GetMapping
    public List<Lead> getAllLeads(){
        return leadService.getAllLeads();

    }


    @GetMapping("/{id}")
    public Lead getLeadById(@PathVariable int id){

        return leadService.getLeadById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable int id){
        leadService.deleteLead(id);
        return "deleted lead successfully";
    }

    @PutMapping("/{id}")
    public Lead editLead(@PathVariable int id,@RequestBody Lead lead){
        return leadService.editLead(id,lead);
    }



}
