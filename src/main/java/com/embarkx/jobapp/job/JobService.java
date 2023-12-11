package com.embarkx.jobapp.job;


import java.util.List;


public interface JobService {
    List<Job> findAll();
    void createNew(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean editJob(Job job);
}
