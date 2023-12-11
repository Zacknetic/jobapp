package com.embarkx.jobapp.job.impl;

import com.embarkx.jobapp.job.Job;
import com.embarkx.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class JobServiceImpl implements JobService {
    static Long currId = 0L;
    private final List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createNew(Job job) {
        job.setId(++currId);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs) {
            if(job.getId().equals(id)) return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        for(Job job : jobs) {
            if(job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            };
        }
        return false;
    }

}
