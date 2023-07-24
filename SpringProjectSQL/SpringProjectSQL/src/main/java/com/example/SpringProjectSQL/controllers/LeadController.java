package com.example.SpringProjectSQL.controllers;

import com.example.SpringProjectSQL.Dto.ConsultantDTO;
import com.example.SpringProjectSQL.Dto.LeadDTO;
import com.example.SpringProjectSQL.model.Lead;
import com.example.SpringProjectSQL.model.Submission;
import com.example.SpringProjectSQL.services.LeadService;
import com.example.SpringProjectSQL.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<LeadDTO> getAllLeads(){


        List<Lead> leadDetails = leadService.getAllLeads();
        return leadDetails.stream().map(
                entity -> mapToDto(entity)
        ).collect(Collectors.toList());

    }


    /*
    @GetMapping
    public List<LeadDetailDTO> getAllLeads() {
        List<LeadDetail> leadDetails = service.getAllLeads();
        return leadDetails.stream().map(
                entity -> mapToDto(entity)
        ).collect(Collectors.toList());
    }
        */


    private static LeadDTO mapToDto(Lead entity) {
        LeadDTO dto = new LeadDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirst_name());
        dto.setLastName(entity.getLast_name());
        dto.setEmailAddress(entity.getEmail_address());
        dto.setPhoneNumber(entity.getPhone_number());
        dto.setConsultantList(entity.getConsultantList().stream().map(
                consultantDetail -> {
                    ConsultantDTO cDto = new ConsultantDTO();
                    cDto.setId(consultantDetail.getConsultant_id());
                    cDto.setLeadId(entity.getId());
                    cDto.setFirstName(consultantDetail.getFirst_name());
                    cDto.setLastName(consultantDetail.getLast_name());
                    cDto.setEmailAddress(consultantDetail.getEmail_address());
                    cDto.setPhoneNumber(consultantDetail.getPhone_number());
                    return cDto;
                }
        ).collect(Collectors.toList()));
        return dto;
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
