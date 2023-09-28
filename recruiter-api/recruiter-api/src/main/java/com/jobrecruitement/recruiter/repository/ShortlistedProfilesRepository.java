package com.jobrecruitement.recruiter.repository;

import com.jobrecruitement.recruiter.entity.ShortlistedProfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortlistedProfilesRepository extends JpaRepository<ShortlistedProfilesEntity, String> {
}
