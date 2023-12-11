package com.embarkx.jobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return this.jobService.findAll();
    }

//    @GetMapping("/jobs/{id}")
//    public Job getJobById(@PathVariable int id) {
//        return jobs.get(id);
//    }
//
    @PostMapping("/jobs")
    public boolean addJob(@RequestBody Job job) {
        this.jobService.createNew(job);
        return true;
    }
//
//    @DeleteMapping("/jobs/{id}")
//    public boolean deleteJobById(@PathVariable int id) {
//        if(jobs.get(id) == null) return false;
//        jobs.remove(id);
//        return true;
//    }

//    @PutMapping("/jobs/{id}")
//    public boolean editJobById(@PathVariable int id, @RequestBody Job job) {
//        if(jobs.get(id) == null) return false;
//        //TODO
//        return true;
//    }

/*
TODO
    @GetMapping("/jobs/{id}/company")
    public boolean getJobCompanyById(@PathVariable int id) {
        if(jobs.get(id) == null) return false;
        return jobs.get(id).getCompany();

 }
*/
}