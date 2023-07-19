package com.example.SpringProjectSQL.controllers;

import com.example.SpringProjectSQL.model.Consultant;
import com.example.SpringProjectSQL.model.Lead;
import com.example.SpringProjectSQL.services.ConsultantService;
import com.example.SpringProjectSQL.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {




    @Autowired
    private ConsultantService consultantService;

    @PostMapping
    public Consultant addConsultant(@RequestBody Consultant consultant){
        return consultantService.addConsultant(consultant);

    }


    @GetMapping
    public List<Consultant> getAllConsultants(){
        return consultantService.getAllConsultants();

    }


    @GetMapping("/{id}")
    public Consultant getConsultantById(@PathVariable int id){

        return consultantService.getConsultantById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteConsultant(@PathVariable int id){
        consultantService.deleteConsultant(id);
        return "deleted lead successfully";
    }

    @PutMapping("/{id}")
    public Consultant editConsultant(@PathVariable int id,@RequestBody Consultant consultant){
        return consultantService.editConsultant(id,consultant);
    }


}
