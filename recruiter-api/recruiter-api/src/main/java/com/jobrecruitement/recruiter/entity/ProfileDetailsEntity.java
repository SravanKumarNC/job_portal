package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "profile_details")
public class ProfileDetailsEntity {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String mobile;
    private String email;

}
