package com.cs544.project.jobservice.value_object;

import com.cs544.project.jobservice.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Job job;
    private Company company;
}
