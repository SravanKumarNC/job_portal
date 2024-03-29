package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.Recruiter;
import com.jobrecruitement.recruiter.service.RecruiterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/recruiters")
@AllArgsConstructor
@Validated
public class RecruiterController {


    @Autowired
    private RecruiterService recruiterService;


    // Without Validation

//    @PostMapping
//    public Recruiter createRecruiter(@Valid @RequestBody Recruiter recruiter){
//        return recruiterService.createRecruiter(recruiter);
//    }


    // With Validation

    @PostMapping
    public ResponseEntity<?> createRecruiter(@Valid @RequestBody Recruiter recruiter, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        Recruiter createdRecruiter = recruiterService.createRecruiter(recruiter);
        return ResponseEntity.ok(createdRecruiter);
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

    // Without Validation

//    @PutMapping("/{id}")
//    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable String id, @RequestBody Recruiter recruiter){
//        recruiter = recruiterService.updateRecruiter(id, recruiter);
//
//        return ResponseEntity.ok(recruiter);
//    }


    // With Validation

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecruiter(@PathVariable String id, @Valid @RequestBody Recruiter recruiter, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        recruiter = recruiterService.updateRecruiter(id, recruiter);
        return ResponseEntity.ok(recruiter);
    }

    @GetMapping
    public List<Recruiter> getAllRecruiters(){
        return recruiterService.getAllRecruiters();
    }

}
