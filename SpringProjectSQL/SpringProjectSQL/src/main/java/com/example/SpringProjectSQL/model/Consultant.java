package com.example.SpringProjectSQL.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "consultant_detail")
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consultant_id;
    private int lead_id;
    private String first_name;
    private String last_name;
    private String email_address;
    private String phone_number;

}
