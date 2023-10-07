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
    private String id;

    @NotNull(message = "Please Enter First Name")
    private String first_name;
    @NotNull(message = "Please Enter Last Name")
    private String last_name;
    @NotNull(message = "Please Enter Company Name")
    private String company_name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    @Min(value = 6, message = "Invalid Zip code")

    private String zip;
    @Pattern(regexp ="^[0-9]{10}$", message = "Mobile no is not valid")
    private String mobile;
    @Email(message = "Enter a valid email address")
    private String email;
}
