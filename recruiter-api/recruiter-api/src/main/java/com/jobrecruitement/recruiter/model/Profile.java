package com.jobrecruitement.recruiter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private String id;

    private String profile_detail_id;

    private String document;

    private String status;

    private String uploaded_on;
}
