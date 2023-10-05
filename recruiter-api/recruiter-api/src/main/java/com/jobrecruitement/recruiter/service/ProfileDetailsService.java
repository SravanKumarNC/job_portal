package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.model.ProfileDetails;

import java.util.List;

public interface ProfileDetailsService {

    public ProfileDetails createProfileDetails(ProfileDetails profileDetails);

    public ProfileDetails getProfileDetailsById(String id);

    public  ProfileDetails getProfilesDetailsById(String id);

    public boolean deleteProfileDetails(String id);

    public ProfileDetails updateProfileDetails(String id, ProfileDetails profileDetails);

    public List<ProfileDetails> getAllProfileDetails();


}
