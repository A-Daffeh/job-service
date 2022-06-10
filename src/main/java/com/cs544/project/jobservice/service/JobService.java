package com.cs544.project.jobservice.service;

import com.cs544.project.jobservice.entity.Job;
import com.cs544.project.jobservice.repository.IJobDao;
import com.cs544.project.jobservice.value_object.Company;
import com.cs544.project.jobservice.value_object.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class JobService {
    @Autowired
    private IJobDao jobDao;
    @Autowired
    private RestTemplate restTemplate;

    public Job addNewJob(Job job) {
        return jobDao.save(job);
    }

    public ResponseTemplate getJobWithCompany(Long id) {
        ResponseTemplate vo = new ResponseTemplate();
        Job job = jobDao.getJobById(id);
        Company company = restTemplate.getForObject("http://localhost:9900/companies/" + job.getCompanyId(), Company.class);
        vo.setJob(job);
        vo.setCompany(company);
        return vo;
    }


}
