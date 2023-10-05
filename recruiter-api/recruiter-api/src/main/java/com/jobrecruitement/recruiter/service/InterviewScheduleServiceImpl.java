package com.jobrecruitement.recruiter.service;

import com.jobrecruitement.recruiter.entity.InterviewScheduleEntity;
import com.jobrecruitement.recruiter.entity.RecruiterEntity;
import com.jobrecruitement.recruiter.model.InterviewSchedule;
import com.jobrecruitement.recruiter.repository.InterviewScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InterviewScheduleServiceImpl implements InterviewScheduleService{

    @Autowired
        private InterviewScheduleRepository interviewScheduleRepository;

    @Override
        public InterviewSchedule createInterviewSchedule(InterviewSchedule interviewSchedule){
        InterviewScheduleEntity interviewScheduleEntity = new InterviewScheduleEntity();

        BeanUtils.copyProperties(interviewSchedule, interviewScheduleEntity);
        interviewScheduleRepository.save(interviewScheduleEntity);
        return interviewSchedule;
    }

    @Override
    public InterviewSchedule getInterviewScheduleById(String id){
        InterviewScheduleEntity interviewScheduleEntity = interviewScheduleRepository.findById(id).get();
        InterviewSchedule interviewSchedule = new InterviewSchedule();
        BeanUtils.copyProperties(interviewScheduleEntity, interviewSchedule);
        return interviewSchedule;
    }

    @Override
    public boolean deleteInterviewSchedule(String id){
        InterviewScheduleEntity interviewScheduleEntity = interviewScheduleRepository.findById(id).get();
        interviewScheduleRepository.delete(interviewScheduleEntity);
        return true;
    }

    @Override
    public List<InterviewSchedule> getAllInterviewSchedules(){
        List<InterviewScheduleEntity> interviewScheduleEntities = interviewScheduleRepository.findAll();
        List<InterviewSchedule> interviewSchedules = interviewScheduleEntities
                .stream()
                .map(res -> new InterviewSchedule(
                        res.getId(),
                        res.getShortlist_id(),
                        res.getSchedule_datetime(),
                        res.getInterview_level(),
                        res.getStatus(),
                        res.getInterviewer_details()))
                .collect(Collectors.toList());
        return interviewSchedules;

    }

    @Override
    public InterviewSchedule updateInterviewSchedule(String id, InterviewSchedule interviewSchedule) {
        InterviewScheduleEntity interviewScheduleEntity = interviewScheduleRepository.findById(id).get();
        interviewScheduleEntity.setId(interviewSchedule.getId());
        interviewScheduleEntity.setInterviewer_details(interviewSchedule.getInterviewer_details());
        interviewScheduleEntity.setSchedule_datetime(interviewSchedule.getSchedule_datetime());
        interviewScheduleEntity.setInterview_level(interviewSchedule.getInterview_level());
        interviewScheduleEntity.setShortlist_id(interviewSchedule.getShortlist_id());
        interviewScheduleEntity.setStatus(interviewSchedule.getStatus());
        interviewScheduleRepository.save(interviewScheduleEntity);
        return interviewSchedule;
    }


}
