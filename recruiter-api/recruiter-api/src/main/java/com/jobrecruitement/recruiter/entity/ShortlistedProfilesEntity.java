package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "shortlisted_profiles")
public class ShortlistedProfilesEntity {

    @Id
    @NotBlank(message = "Please Enter Id")
    private String id;
    private String recruiter_id;
    private String profile_id;
    @NotBlank(message = "Please Enter Company Name")
    private String company_name;
    @NotBlank(message = "Please Enter Status")
    private String status;
    @NotBlank(message = "Please Enter Last Interviewed on")
    private String last_interviewed_on;
}
