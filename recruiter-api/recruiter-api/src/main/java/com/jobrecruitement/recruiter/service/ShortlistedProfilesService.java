package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.model.ShortlistedProfiles;

import java.util.List;

public interface ShortlistedProfilesService {

    public ShortlistedProfiles createShortlistedProfiles(ShortlistedProfiles shortlistedProfiles);

    public ShortlistedProfiles getShortlistedProfilesById(String id);

    public boolean deleteShortlistedProfiles(String id);

    public ShortlistedProfiles updateShortlistedProfiles(String id, ShortlistedProfiles shortlistedProfiles);

    public List<ShortlistedProfiles> getAllShortlistedProfiles();

}
