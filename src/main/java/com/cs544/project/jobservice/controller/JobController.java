package com.cs544.project.jobservice.controller;

import com.cs544.project.jobservice.entity.Job;
import com.cs544.project.jobservice.service.JobService;
import com.cs544.project.jobservice.value_object.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/add", consumes = "application/json")
    public Job addNewJob(@RequestBody Job job) {
        return jobService.addNewJob(job);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseTemplate getJobWithCompany(@PathVariable Long id) {
        return jobService.getJobWithCompany(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseTemplate updateJob(@PathVariable Long id, @RequestBody Job job) {
        if (id != job.getJobId())
            throw new IllegalArgumentException();
        jobService.update(job);
        return jobService.getJobWithCompany(job.getCompanyId());
    }

}
