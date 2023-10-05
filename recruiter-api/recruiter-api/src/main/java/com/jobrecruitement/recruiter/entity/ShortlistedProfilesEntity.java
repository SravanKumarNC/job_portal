package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "shortlisted_profiles")
public class ShortlistedProfilesEntity {

    @Id
    private String id;
    private String recruiter_id;
    private String profile_id;
    private String company_name;
    private String status;
    private String last_interviewed_on;
}
