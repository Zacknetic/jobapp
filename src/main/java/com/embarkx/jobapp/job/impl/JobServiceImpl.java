package com.embarkx.jobapp.job.impl;

import com.embarkx.jobapp.job.Job;
import com.embarkx.jobapp.job.JobRepository;
import com.embarkx.jobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createNew(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean deleteJobById(Long id) {
        jobRepository.deleteById(id);
        return jobRepository.findById(id).isPresent();
    }

    @Override
    public boolean editJob(Job _job) {

        Optional<Job> jobOpt = jobRepository.findById(_job.getId());
        if (jobOpt.isPresent()) {
            Job job = jobOpt.get();
            job.setDescription(_job.getDescription());
            job.setLocation(_job.getLocation());
            job.setTitle(_job.getTitle());
            job.setMaxSalary(_job.getMaxSalary());
            job.setMinSalary(_job.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
