package com.jobrecruitement.recruiter.controller;

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
@RequestMapping("/api/v1/profileDetails")
@AllArgsConstructor
public class ProfileDetailsController {

    @Autowired
        private ProfileDetailsService profileDetailsService;

        @PostMapping("/{id}")
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
            Map<String, Boolean> response = HashMap<>();
            response.put("deleted", deleted);

            return ProfileDetails.ok(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ProfileDetails> updateProfileDetails(@PathVariable String id, @RequestBody ProfileDetails profileDetails){
            profileDetails = profileDetailsService.updateProfileDetails(id, profileDetails);

            return ProfileDetails.ok(profileDetails);
        }

        @GetMapping
        public List<ProfileDetails> getAllProfileDetails(){
            return profileDetailsService.getAllProfileDetails();
        }

}
