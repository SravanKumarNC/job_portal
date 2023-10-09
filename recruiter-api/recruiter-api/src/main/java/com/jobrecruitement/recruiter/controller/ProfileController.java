package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.Profile;
import com.jobrecruitement.recruiter.model.Recruiter;
import com.jobrecruitement.recruiter.service.ProfileService;
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
@RequestMapping("/api/v1/profiles")
@AllArgsConstructor
public class ProfileController {

    @Autowired
        private ProfileService profileService;


    // Without Validation

//        @PostMapping
//        public Profile createProfile(@RequestBody Profile profile){
//            return profileService.createProfile(profile);
//        }


    // With Validation

        @PostMapping
        public ResponseEntity<?> createProfile(@Valid @RequestBody Profile profile, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            Profile createdProfile = profileService.createProfile(profile);
            return ResponseEntity.ok(createdProfile);
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

        // Without Validation

//        @PutMapping("/{id}")
//        public ResponseEntity<Profile> updateProfile(@PathVariable String id, @RequestBody Profile profile){
//            profile = profileService.updateProfile(id, profile);
//
//            return ResponseEntity.ok(profile);
//        }


        // With Validation

        @PutMapping("/{id}")
        public ResponseEntity<?> updateProfile(@PathVariable String id, @Valid @RequestBody Profile profile, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            profile = profileService.updateProfile(id, profile);
            return ResponseEntity.ok(profile);
        }

        @GetMapping
        public List<Profile> getAllProfiles(){
            return profileService.getAllProfiles();
        }

}
