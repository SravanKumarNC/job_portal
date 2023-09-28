package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.model.Recruiter;

import java.util.List;

public interface RecruiterService {
    public Recruiter createRecruiter(Recruiter recruiter);

    public Recruiter getRecruiterById(String id);

    public boolean deleteRecruiter(String id);

    public Recruiter updateRecruiter(String id, Recruiter recruiter);

    public List<Recruiter> getAllRecruiters();
}
