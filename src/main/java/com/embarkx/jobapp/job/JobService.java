package com.embarkx.jobapp.job;


import java.util.List;


public interface JobService {
    List<Job> findAll();
    void createNew(Job job);
}
