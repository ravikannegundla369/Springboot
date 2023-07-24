package com.example.SpringProjectSQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


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

    @OneToMany(mappedBy="lead", cascade = CascadeType.ALL)
    private List<Consultant> consultantList;

}
