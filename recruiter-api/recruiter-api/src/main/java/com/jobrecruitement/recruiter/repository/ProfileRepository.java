package com.jobrecruitement.recruiter.repository;

import com.jobrecruitement.recruiter.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {
}
