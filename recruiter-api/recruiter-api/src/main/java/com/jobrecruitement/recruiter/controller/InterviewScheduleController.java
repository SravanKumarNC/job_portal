package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.InterviewSchedule;
import com.jobrecruitement.recruiter.service.InterviewScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/interviewSchedule")
@AllArgsConstructor
public class InterviewScheduleController {

    @Autowired
        private InterviewScheduleService interviewScheduleService;

        @PostMapping
        public InterviewSchedule createInterviewSchedule(@RequestBody InterviewSchedule interviewSchedule){
            return interviewScheduleService.createInterviewSchedule(interviewSchedule);

        }

        @GetMapping("/{id}")
        public ResponseEntity<InterviewSchedule> getInterviewSchedule(@PathVariable String id){
            InterviewSchedule interviewSchedule = new InterviewSchedule();
            interviewSchedule = interviewScheduleService.getInterviewScheduleById(id);
            return ResponseEntity.ok(interviewSchedule);

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteInterviewSchedule(@PathVariable String id){
            boolean deleted = false;

            deleted = interviewScheduleService.deleteInterviewSchedule(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<InterviewSchedule> updateInterviewSchedule(@PathVariable String id, @RequestBody InterviewSchedule interviewSchedule){
            interviewSchedule = interviewScheduleService.updateInterviewSchedule(id, interviewSchedule);

            return ResponseEntity.ok(interviewSchedule);
        }

        @GetMapping
        public List<InterviewSchedule> getAllInterviewSchedule(){
            return interviewScheduleService.getAllInterviewSchedules();
        }
}
