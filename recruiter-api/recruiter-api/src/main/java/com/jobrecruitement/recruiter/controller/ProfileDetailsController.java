package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.entity.ProfileDetailsEntity;
import com.jobrecruitement.recruiter.model.ProfileDetails;
import com.jobrecruitement.recruiter.service.ProfileDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/profileDetails")
@AllArgsConstructor
public class ProfileDetailsController {

    @Autowired
        private ProfileDetailsService profileDetailsService;

        @PostMapping
        public ProfileDetails createProfileDetails(@RequestBody ProfileDetails profileDetails){
            return profileDetailsService.createProfileDetails(profileDetails);
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

        @PutMapping("/{id}")
        public ResponseEntity<ProfileDetails> updateProfileDetails(@PathVariable String id, @RequestBody ProfileDetails profileDetails){
            profileDetails = profileDetailsService.updateProfileDetails(id, profileDetails);

            return ResponseEntity.ok(profileDetails);
        }

        @GetMapping
        public List<ProfileDetails> getAllProfileDetails(){
            return profileDetailsService.getAllProfileDetails();
        }

}
