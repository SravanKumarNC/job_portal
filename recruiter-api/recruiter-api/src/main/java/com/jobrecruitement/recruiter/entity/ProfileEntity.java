package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Data
@Table(name = "profile")
public class ProfileEntity {


    @Id
    @NotBlank(message = "Please Enter Id")
    private String id;
    private String profile_detail_id;
    @NotBlank(message = "Please Enter document")
    private String document;
    @NotBlank(message = "Please Enter status")
    private String status;
    private String uploaded_on;
}
