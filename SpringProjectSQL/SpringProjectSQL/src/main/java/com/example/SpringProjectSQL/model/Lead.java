package com.example.SpringProjectSQL.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "lead_detail")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email_address;
    private String phone_number;


}
