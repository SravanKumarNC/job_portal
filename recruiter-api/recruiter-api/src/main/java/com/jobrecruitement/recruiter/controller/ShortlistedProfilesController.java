package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.Recruiter;
import com.jobrecruitement.recruiter.model.ShortlistedProfiles;
import com.jobrecruitement.recruiter.service.ShortlistedProfilesService;
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
@RequestMapping("/api/v1/shortlistedProfiles")
@AllArgsConstructor
public class ShortlistedProfilesController {

    @Autowired
        private ShortlistedProfilesService shortlistedProfilesService;

    // Without Validation

//        @PostMapping
//        public ShortlistedProfiles createShortlistedProfiles(@RequestBody ShortlistedProfiles shortlistedProfiles){
//            return shortlistedProfilesService.createShortlistedProfiles(shortlistedProfiles);
//        }


    // With Validation

        @PostMapping
        public ResponseEntity<?> createShortlistedProfiles(@Valid @RequestBody ShortlistedProfiles shortlistedProfiles, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            ShortlistedProfiles createdShortlistedProfiles = shortlistedProfilesService.createShortlistedProfiles(shortlistedProfiles);
            return ResponseEntity.ok(createdShortlistedProfiles);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ShortlistedProfiles> getShortlistedProfiles(@PathVariable String id){
            ShortlistedProfiles shortlistedProfiles = new ShortlistedProfiles();
            shortlistedProfiles = shortlistedProfilesService.getShortlistedProfilesById(id);
            return ResponseEntity.ok(shortlistedProfiles);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteShortlistedProfiles(@PathVariable String id){
            boolean deleted = false;

            deleted = shortlistedProfilesService.deleteShortlistedProfiles(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);

        }

        // Without Validation

//        @PutMapping("/{id}")
//        public ResponseEntity<ShortlistedProfiles> updateShortlistedProfiles(@PathVariable String id, @RequestBody ShortlistedProfiles shortlistedProfiles){
//            shortlistedProfiles = shortlistedProfilesService.updateShortlistedProfiles(id, shortlistedProfiles);
//
//            return ResponseEntity.ok(shortlistedProfiles);
//        }


    // With Validation

        @PutMapping("/{id}")
        public ResponseEntity<?> updateShortlistedProfiles(@PathVariable String id, @Valid @RequestBody ShortlistedProfiles shortlistedProfiles, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = result.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            shortlistedProfiles = shortlistedProfilesService.updateShortlistedProfiles(id, shortlistedProfiles);
            return ResponseEntity.ok(shortlistedProfiles);
        }

        @GetMapping
        public List<ShortlistedProfiles> getShortlistedProfiles(){
            return shortlistedProfilesService.getAllShortlistedProfiles();
        }

}
