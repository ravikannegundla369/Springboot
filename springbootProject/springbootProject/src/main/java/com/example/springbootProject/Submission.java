package com.example.springbootProject;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "SUBMISSIONS")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private Date  date;
    private String name;
    private String leadName;
    private String vendorName;
    private String salesPersonName;
    private String salesPersonPhNo;
    private String salesPersonEmail;
    private String anyImplemationPatner;
    private String clientName;
    private String rate;


}
