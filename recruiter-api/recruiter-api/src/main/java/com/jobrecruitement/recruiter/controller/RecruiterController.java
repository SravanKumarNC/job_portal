package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.Recruiter;
import com.jobrecruitement.recruiter.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/recruiters")
@AllArgsConstructor
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public Recruiter createRecruiter(@RequestBody Recruiter recruiter){
        return recruiterService.createRecruiter(recruiter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiter(@PathVariable String id){
        Recruiter recruiter = new Recruiter();
        recruiter = recruiterService.getRecruiterById(id);
        return ResponseEntity.ok(recruiter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecruiter(@PathVariable String id){
        boolean deleted = false;

        deleted = recruiterService.deleteRecruiter(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/{id}")
    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable String id, @RequestBody Recruiter recruiter){
        recruiter = recruiterService.updateRecruiter(id, recruiter);

        return ResponseEntity.ok(recruiter);
    }

    @GetMapping
    public List<Recruiter> getAllRecruiters(){
        return recruiterService.getAllRecruiters();
    }

}
