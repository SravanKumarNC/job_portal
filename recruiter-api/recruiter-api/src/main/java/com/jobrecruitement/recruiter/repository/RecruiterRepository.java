package com.jobrecruitement.recruiter.repository;

import com.jobrecruitement.recruiter.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, String> {

}
