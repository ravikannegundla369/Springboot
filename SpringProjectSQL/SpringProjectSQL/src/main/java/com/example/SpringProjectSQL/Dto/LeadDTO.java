package com.example.SpringProjectSQL.Dto;

import lombok.Data;

import java.util.List;

@Data
public class LeadDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private List<ConsultantDTO> consultantList;


}
