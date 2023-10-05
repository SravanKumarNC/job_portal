package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.model.Profile;

import java.util.List;

public interface ProfileService {

    public Profile createProfile(Profile profile);

    public Profile getProfileById(String id);

    public boolean deleteProfile(String id);

    public Profile updateProfile(String id, Profile profile);

    public List<Profile> getAllProfiles();


}
