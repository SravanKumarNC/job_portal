package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.model.InterviewSchedule;

import java.util.List;

public interface InterviewScheduleService {

    public InterviewSchedule createInterviewSchedule(InterviewSchedule interviewSchedule);

    public InterviewSchedule getInterviewScheduleById(String id);

    public boolean deleteInterviewSchedule(String id);

    public List<InterviewSchedule> getAllInterviewSchedules();

    public InterviewSchedule updateInterviewSchedule(String id, InterviewSchedule interviewSchedule);




}
