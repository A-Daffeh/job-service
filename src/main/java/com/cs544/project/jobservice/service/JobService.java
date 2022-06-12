package com.cs544.project.jobservice.service;

import com.cs544.project.jobservice.entity.Job;
import com.cs544.project.jobservice.repository.IJobDao;
import com.cs544.project.jobservice.value_object.Company;
import com.cs544.project.jobservice.value_object.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private IJobDao jobDao;
    @Autowired
    private RestTemplate restTemplate;

    public Job addNewJob(Job job) {
        return jobDao.save(job);
    }

    public ResponseTemplate getJobWithCompany(Long jobId) {
        ResponseTemplate vo = new ResponseTemplate();
        Job job = jobDao.findById(jobId).orElse(null);
        assert job != null;
        Company company = restTemplate.getForObject("http://COMPANY-SERVICE/companies/" + job.getCompanyId(), Company.class);
        vo.setJob(job);
        vo.setCompany(company);
        return vo;
    }

    public Job update(Job job) {
        return jobDao.save(job);
    }

    public void deleteJob(Long id) {
        jobDao.deleteById(id);
    }
}
