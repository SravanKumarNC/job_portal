package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.entity.RecruiterEntity;
import com.jobrecruitement.recruiter.model.Recruiter;
import com.jobrecruitement.recruiter.repository.RecruiterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecruiterServiceImpl implements RecruiterService{

    @Autowired
    private RecruiterRepository recruiterRepository;
    @Override
    public Recruiter createRecruiter(Recruiter recruiter) {
        RecruiterEntity recruiterEntity = new RecruiterEntity();

        BeanUtils.copyProperties(recruiter, recruiterEntity);
        recruiterRepository.save(recruiterEntity);
        return recruiter;
    }

    @Override
    public Recruiter getRecruiterById(String id) {
        RecruiterEntity recruiterEntity = recruiterRepository.findById(id).get();
        Recruiter recruiter = new Recruiter();
        BeanUtils.copyProperties(recruiterEntity, recruiter);
        return recruiter;
    }

    @Override
    public boolean deleteRecruiter(String id) {
        RecruiterEntity recruiterEntity = recruiterRepository.findById(id).get();
        recruiterRepository.delete(recruiterEntity);
        return true;
    }

    @Override
    public Recruiter updateRecruiter(String id, Recruiter recruiter) {
        RecruiterEntity recruiterEntity = recruiterRepository.findById(id).get();
        recruiterEntity.setId(recruiter.getId());
        recruiterEntity.setCity(recruiter.getCity());
        recruiterEntity.setEmail(recruiter.getEmail());
        recruiterEntity.setZip(recruiter.getZip());
        recruiterEntity.setMobile(recruiter.getMobile());
        recruiterEntity.setAddress1(recruiter.getAddress1());
        recruiterEntity.setAddress2(recruiter.getAddress2());
        recruiterEntity.setCompany_name(recruiter.getCompany_name());
        recruiterEntity.setState(recruiter.getState());
        recruiterEntity.setFirst_name(recruiter.getFirst_name());
        recruiterEntity.setLast_name(recruiter.getLast_name());

        recruiterRepository.save(recruiterEntity);
        return recruiter;
    }

    @Override
    public List<Recruiter> getAllRecruiters() {
        List<RecruiterEntity> recruiterEntities = recruiterRepository.findAll();
        List<Recruiter> recruiters = recruiterEntities
                .stream()
                .map(res -> new Recruiter(
                        res.getId(),
                        res.getFirst_name(),
                        res.getLast_name(),
                        res.getCompany_name(),
                        res.getAddress1(),
                        res.getAddress2(),
                        res.getCity(),
                        res.getState(),
                        res.getZip(),
                        res.getMobile(),
                        res.getEmail()))
                .collect(Collectors.toList());
        return recruiters;
    }
}
