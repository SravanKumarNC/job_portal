package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.entity.ProfileEntity;
import com.jobrecruitement.recruiter.model.Profile;
import com.jobrecruitement.recruiter.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile){
        ProfileEntity profileEntity = new ProfileEntity();

        BeanUtils.copyProperties(profile, profileEntity);
        profileRepository.save(profileEntity);
        return profile;
    }

    @Override
    public Profile getProfileById(String id){
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        Profile profile = new Profile();
        BeanUtils.copyProperties(profileEntity, profile);
        return profile;
    }

    @Override
    public boolean deleteProfile(String id){
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
        return true;
    }

    @Override
    public Profile updateProfile(String id, Profile profile) {
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileEntity.setId(profile.getId());
        profileEntity.setProfile_detail_id(profile.getProfile_detail_id());
        profileEntity.setDocument(profile.getDocument());
        profileEntity.setStatus(profile.getStatus());
        profileEntity.setUploaded_on(profile.getUploaded_on());

        profileRepository.save(profileEntity);
        return profile;
    }



    @Override
    public List<Profile> getAllProfiles() {
        List<ProfileEntity> profileEntities = profileRepository.findAll();
        List<Profile> profiles = profileEntities
                .stream()
                .map(res -> new Profile(
                        res.getId(),
                        res.getProfile_detail_id(),
                        res.getDocument(),
                        res.getStatus(),
                        res.getUploaded_on()))
                .collect(Collectors.toList());
        return profiles;
    }

}
