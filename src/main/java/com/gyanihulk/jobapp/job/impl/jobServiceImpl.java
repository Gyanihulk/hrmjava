package com.gyanihulk.jobapp.job.impl;

import com.gyanihulk.jobapp.job.Job;
import com.gyanihulk.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class jobServiceImpl implements JobService {
    private List<Job> jobs =new ArrayList<>();
    private Long nextId=1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }
}
