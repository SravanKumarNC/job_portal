package com.jobrecruitement.recruiter.repository;

import com.jobrecruitement.recruiter.entity.ProfileDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDetailsRepository extends JpaRepository<ProfileDetailsEntity, String> {
}
