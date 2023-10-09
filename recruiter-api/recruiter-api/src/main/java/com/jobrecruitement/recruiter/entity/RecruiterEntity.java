package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Data
@Table(name = "recruiter")
public class RecruiterEntity {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Valid
    @Id
    @NotBlank(message = "Please Enter Id")
    private String id;
    @NotBlank(message = "Please Enter First Name")
    private String first_name;
    @NotBlank(message = "Please Enter Last Name")
    private String last_name;
    @NotBlank(message = "Please Enter Company Name")
    private String company_name;
    @NotBlank(message = "Please Enter Address")
    private String address1;
    private String address2;
    @NotBlank(message = "Please Enter City")
    private String city;
    @NotBlank(message = "Please Enter state")
    private String state;
    @Pattern(regexp = "^\\d{6}$", message = "Enter valid zip code")
    private String zip;
    @Pattern(regexp ="^[0-9]{10}$", message = "Mobile no is not valid")
    private String mobile;
    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Enter a valid email address")
    private String email;
}
