package com.example.SpringProjectSQL.Dto;

import lombok.Data;

@Data
public class ConsultantDTO {

    private int id;
    private int leadId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

}
