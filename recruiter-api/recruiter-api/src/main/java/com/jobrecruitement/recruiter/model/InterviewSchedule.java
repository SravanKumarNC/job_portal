package com.jobrecruitement.recruiter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewSchedule {

    private String id;

    private String shortlist_id;

    private String schedule_datetime;

    private String interview_level;

    private String status;

    private String interviewer_details;
}
