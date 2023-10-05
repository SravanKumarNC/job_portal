package com.jobrecruitement.recruiter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDetails {

    private String id;

    private String first_name;

    private String last_name;

    private String mobile;

    private String email;
}
