package com.cs544.project.jobservice.repository;

import com.cs544.project.jobservice.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobDao extends JpaRepository<Job, Long> {
    Job getJobByJobId(Long jobId);
}
