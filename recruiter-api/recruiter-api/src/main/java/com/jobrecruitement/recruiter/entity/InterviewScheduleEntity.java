package com.jobrecruitement.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "interview_schedule")
public class InterviewScheduleEntity {

    @Id
    private String id;
    private String shortlist_id;
    private String schedule_datetime;
    private String interview_level;
    private String status;
    private String interviewer_details;

}
