package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.entity.ProfileDetailsEntity;
import com.jobrecruitement.recruiter.model.ProfileDetails;
import com.jobrecruitement.recruiter.model.Recruiter;
import com.jobrecruitement.recruiter.service.ProfileDetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/profileDetails")
@AllArgsConstructor
public class ProfileDetailsController {

    @Autowired
        private ProfileDetailsService profileDetailsService;

    // Without Validation

//        @PostMapping
//        public ProfileDetails createProfileDetails(@RequestBody ProfileDetails profileDetails){
//            return profileDetailsService.createProfileDetails(profileDetails);
//        }

    // With Validation

        @PostMapping
        public ResponseEntity<?> createProfileDetails(@Valid @RequestBody ProfileDetails profileDetails, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            ProfileDetails createdProfileDetails = profileDetailsService.createProfileDetails(profileDetails);
            return ResponseEntity.ok(createdProfileDetails);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProfileDetails> getProfileDetails(@PathVariable String id){
            ProfileDetails profileDetails = new ProfileDetails();
            profileDetails = profileDetailsService.getProfileDetailsById(id);
            return ResponseEntity.ok(profileDetails);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteProfileDetails(@PathVariable String id){
            boolean deleted = false;

            deleted = profileDetailsService.deleteProfileDetails(id);
            Map<String, Boolean> response =new HashMap<>();
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);
        }

    // Without Validation

//        @PutMapping("/{id}")
//        public ResponseEntity<ProfileDetails> updateProfileDetails(@PathVariable String id, @RequestBody ProfileDetails profileDetails){
//            profileDetails = profileDetailsService.updateProfileDetails(id, profileDetails);
//
//            return ResponseEntity.ok(profileDetails);
//        }


        // With Validation

        @PutMapping("/{id}")
        public ResponseEntity<?> updateProfileDetails(@PathVariable String id, @Valid @RequestBody ProfileDetails profileDetails, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            profileDetails = profileDetailsService.updateProfileDetails(id, profileDetails);
            return ResponseEntity.ok(profileDetails);
        }

        @GetMapping
        public List<ProfileDetails> getAllProfileDetails(){
            return profileDetailsService.getAllProfileDetails();
        }

}
