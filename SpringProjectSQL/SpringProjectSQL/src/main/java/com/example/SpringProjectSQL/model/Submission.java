package com.example.SpringProjectSQL.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int submission_id;
    private int consultant_id;
    private String submission_date;
    private String vendor_company;
    private String vendor_name;
    private String vendor_email_address;
    private String vendor_phone_number;
    private String implementation_partner;
    private String client_name;
    private long pay_rate;
    private String submission_status;
    private String submission_type;
    private String city;
    private String state;
   private String zip;

}

