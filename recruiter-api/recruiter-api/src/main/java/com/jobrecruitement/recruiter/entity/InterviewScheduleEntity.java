package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Data
@Table(name = "interview_schedule")
public class InterviewScheduleEntity {

    @Id
    @NotBlank(message = "Please Enter Id")
    private String id;
    private String shortlist_id;
    @NotBlank(message = "Please Enter Schedule Datetime")
    private String schedule_datetime;
    @NotBlank(message = "Please Enter Interview level")
    private String interview_level;
    @NotBlank(message = "Please Enter Status")
    private String status;
    @NotBlank(message = "Please Enter Interview Details")
    private String interviewer_details;

}
