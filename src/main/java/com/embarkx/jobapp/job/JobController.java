package com.embarkx.jobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    public JobController(JobService _jobService) {
        jobService = _jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobService.findAll();
        if (!jobs.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(jobs, HttpStatus.OK);

    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        jobService.createNew(job);
        return new ResponseEntity<>("Job added successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Boolean> deleteJobById(@PathVariable Long id) {
        if (!jobService.deleteJobById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

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