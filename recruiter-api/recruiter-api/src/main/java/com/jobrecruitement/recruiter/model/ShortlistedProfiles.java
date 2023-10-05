package com.jobrecruitement.recruiter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortlistedProfiles {

    private String id;

    private String recruiter_id;

    private String profile_id;

    private String company_name;

    private String status;

    private String last_interviewed_on;
}
