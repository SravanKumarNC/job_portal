package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.entity.ProfileDetailsEntity;
import com.jobrecruitement.recruiter.model.ProfileDetails;
import com.jobrecruitement.recruiter.repository.ProfileDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfileDetailsServiceImpl implements ProfileDetailsService{

    @Autowired
        private ProfileDetailsRepository profileDetailsRepository;

    @Override
        public ProfileDetails createProfileDetails(ProfileDetails profileDetails) {
        ProfileDetailsEntity profileDetailsEntity = new ProfileDetailsEntity();

        BeanUtils.copyProperties(profileDetails, profileDetailsEntity);
        profileDetailsRepository.save(profileDetailsEntity);
        return profileDetails;
    }

    @Override
    public ProfileDetails getProfileDetailsById(String id) {
        return null;
    }

    @Override
    public ProfileDetails getProfilesDetailsById(String id) {
        ProfileDetailsEntity profileDetailsEntity = profileDetailsRepository.findById(id).get();
        ProfileDetails profileDetails = new ProfileDetails();
        BeanUtils.copyProperties(profileDetailsEntity, profileDetails);
        return profileDetails;

    }

    @Override
    public boolean deleteProfileDetails(String id){
        ProfileDetailsEntity profileDetailsEntity = profileDetailsRepository.findById(id).get();
        profileDetailsRepository.delete(profileDetailsEntity);
        return true;
    }

    @Override
    public ProfileDetails updateProfileDetails(String id, ProfileDetails profileDetails){
        ProfileDetailsEntity profileDetailsEntity = profileDetailsRepository.findById(id).get();
        profileDetailsEntity.setId(profileDetails.getId());
        profileDetailsEntity.setFirst_name(profileDetails.getFirst_name());
        profileDetailsEntity.setLast_name(profileDetails.getLast_name());
        profileDetailsEntity.setMobile(profileDetails.getMobile());
        profileDetailsEntity.setEmail(profileDetails.getEmail());

        profileDetailsRepository.save(profileDetailsEntity);
        return profileDetails;
    }

    @Override
    public List<ProfileDetails> getAllProfileDetails() {
        List<ProfileDetailsEntity> profileDetailsEntities = profileDetailsRepository.findAll();
        List<ProfileDetails> profileDetails = profileDetailsEntities
                .stream()
                .map(res -> new ProfileDetails(
                        res.getId(),
                        res.getFirst_name(),
                        res.getLast_name(),
                        res.getMobile(),
                        res.getEmail()))
                .collect(Collectors.toList());
        return profileDetails;
    }












}
