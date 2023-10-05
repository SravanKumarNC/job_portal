package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.entity.ShortlistedProfilesEntity;
import com.jobrecruitement.recruiter.model.ShortlistedProfiles;
import com.jobrecruitement.recruiter.repository.ShortlistedProfilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShortlistedProfilesServiceImpl implements ShortlistedProfilesService{

    @Autowired
        private ShortlistedProfilesRepository shortlistedProfilesRepository;

    @Override
    public ShortlistedProfiles createShortlistedProfiles(ShortlistedProfiles shortlistedProfiles){
        ShortlistedProfilesEntity shortlistedProfilesEntity = new ShortlistedProfilesEntity();

        BeanUtils.copyProperties(shortlistedProfiles, shortlistedProfilesEntity);
        shortlistedProfilesRepository.save(shortlistedProfilesEntity);
        return shortlistedProfiles;
    }

    @Override
    public ShortlistedProfiles getShortlistedProfilesById(String id) {
        ShortlistedProfilesEntity shortlistedProfilesEntity = shortlistedProfilesRepository.findById(id).get();
        ShortlistedProfiles shortlistedProfiles = new ShortlistedProfiles();
        BeanUtils.copyProperties(shortlistedProfilesEntity,shortlistedProfiles);
        return shortlistedProfiles;
    }

    @Override
    public boolean deleteShortlistedProfiles(String id) {
        ShortlistedProfilesEntity shortlistedProfilesEntity = shortlistedProfilesRepository.findById(id).get();
        shortlistedProfilesRepository.delete(shortlistedProfilesEntity);
        return true;
    }

    @Override
    public ShortlistedProfiles updateShortlistedProfiles(String id, ShortlistedProfiles shortlistedProfiles){
        ShortlistedProfilesEntity shortlistedProfilesEntity = shortlistedProfilesRepository.findById(id).get();
        shortlistedProfilesEntity.setId(shortlistedProfiles.getId());
        shortlistedProfilesEntity.setRecruiter_id(shortlistedProfiles.getRecruiter_id());
        shortlistedProfilesEntity.setProfile_id(shortlistedProfiles.getProfile_id());
        shortlistedProfilesEntity.setCompany_name(shortlistedProfiles.getCompany_name());
        shortlistedProfilesEntity.setStatus(shortlistedProfiles.getStatus());
        shortlistedProfilesEntity.setLast_interviewed_on(shortlistedProfiles.getLast_interviewed_on());

        shortlistedProfilesRepository.save(shortlistedProfilesEntity);
        return shortlistedProfiles;
    }

    @Override
    public List<ShortlistedProfiles> getAllShortlistedProfiles(){
        List<ShortlistedProfilesEntity> shortlistedProfilesEntities = shortlistedProfilesRepository.findAll();
        List<ShortlistedProfiles> shortlistedProfiles = shortlistedProfilesEntities
                .stream()
                .map(res -> new ShortlistedProfiles(
                        res.getId(),
                        res.getRecruiter_id(),
                        res.getProfile_id(),
                        res.getCompany_name(),
                        res.getStatus(),
                        res.getLast_interviewed_on()))
                .collect(Collectors.toList());
        return shortlistedProfiles;



    }






}
