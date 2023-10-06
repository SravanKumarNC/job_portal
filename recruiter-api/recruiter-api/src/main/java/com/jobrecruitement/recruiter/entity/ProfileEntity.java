package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "profile")
public class ProfileEntity {

    @Id
    private String id;
    private String profile_detail_id;
    private String document;
    private String status;
    private String uploaded_on;
}
