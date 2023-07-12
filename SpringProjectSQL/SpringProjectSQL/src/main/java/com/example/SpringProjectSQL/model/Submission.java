package com.example.SpringProjectSQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String technology;
    private String vendor;
    private String email;
    private String mobile;
    private String client;
    private String implementation;
    private String lead;
    private String student;
    private String recruiter;
    private long payRate;
    private Boolean submitted;

}