package com.jobrecruitement.recruiter.repository;

import com.jobrecruitement.recruiter.entity.InterviewScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewScheduleRepository extends JpaRepository<InterviewScheduleEntity, String> {
}
