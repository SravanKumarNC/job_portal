package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "recruiter")
public class RecruiterEntity {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String company_name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String mobile;
    private String email;
}
