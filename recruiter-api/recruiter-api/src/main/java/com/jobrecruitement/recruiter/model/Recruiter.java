package com.jobrecruitement.recruiter.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruiter {

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
