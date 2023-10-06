package com.jobrecruitement.recruiter.controller;

import com.jobrecruitement.recruiter.model.ShortlistedProfiles;
import com.jobrecruitement.recruiter.service.ShortlistedProfilesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/shortlistedProfiles")
@AllArgsConstructor
public class ShortlistedProfilesController {

    @Autowired
        private ShortlistedProfilesService shortlistedProfilesService;

        @PostMapping
        public ShortlistedProfiles createShortlistedProfiles(@RequestBody ShortlistedProfiles shortlistedProfiles){
            return shortlistedProfilesService.createShortlistedProfiles(shortlistedProfiles);
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

        @PutMapping("/{id}")
        public ResponseEntity<ShortlistedProfiles> updateShortlistedProfiles(@PathVariable String id, @RequestBody ShortlistedProfiles shortlistedProfiles){
            shortlistedProfiles = shortlistedProfilesService.updateShortlistedProfiles(id, shortlistedProfiles);

            return ResponseEntity.ok(shortlistedProfiles);
        }

        @GetMapping
        public List<ShortlistedProfiles> getShortlistedProfiles(){
            return shortlistedProfilesService.getAllShortlistedProfiles();
        }

}
