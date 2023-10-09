package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Entity
@Data
@Table(name = "profile_details")
public class ProfileDetailsEntity {

    @Id
    @NotBlank(message = "Please Enter Id")
    private String id;
    @NotBlank(message = "Please Enter First Name")
    private String first_name;
    @NotBlank(message = "Please Enter Last Name")
    private String last_name;
    @Pattern(regexp ="^[0-9]{10}$", message = "Mobile no is not valid")
    private String mobile;
    @Email(message = "Enter a valid email address")
    private String email;

}
