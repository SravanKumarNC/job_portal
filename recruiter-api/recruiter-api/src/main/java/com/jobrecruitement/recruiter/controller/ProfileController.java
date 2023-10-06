package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.Profile;
import com.jobrecruitement.recruiter.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/profiles")
@AllArgsConstructor
public class ProfileController {

    @Autowired
        private ProfileService profileService;

        @PostMapping
        public Profile createProfile(@RequestBody Profile profile){
            return profileService.createProfile(profile);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Profile> getProfile(@PathVariable String id){
            Profile profile = new Profile();
            profile = profileService.getProfileById(id);
            return ResponseEntity.ok(profile);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteProfile(@PathVariable String id){
            boolean deleted = false;

            deleted = profileService.deleteProfile(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Profile> updateProfile(@PathVariable String id, @RequestBody Profile profile){
            profile = profileService.updateProfile(id, profile);

            return ResponseEntity.ok(profile);
        }

        @GetMapping
        public List<Profile> getAllProfiles(){
            return profileService.getAllProfiles();
        }

}
