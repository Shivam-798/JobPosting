package com.job.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.job.model.JobPosting;
import com.job.model.SearchCriteria;
import com.job.service.JobPostingServices;

import java.util.List;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {

    @Autowired
    private JobPostingServices service;

    @PostMapping
    public JobPosting createJobPosting(@RequestBody JobPosting jobPosting) {
        return service.createJobPosting(jobPosting);
    }

    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        return service.getAllJobPosting();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
        return service.getJobPostingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        return ResponseEntity.ok(service.updateJobPosting(id, jobPostingDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        service.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/search")
//    public List<JobPosting> searchJobPostings(@RequestParam String keyword, @RequestParam String location, @RequestParam String skills) {
//        return service.searchJobPosting(keyword, location, skills);
//    }
    
    @PostMapping("/search")
    public List<JobPosting> searchJobPostings(@RequestBody SearchCriteria searchCriteria) {
        return service.searchJobPosting(searchCriteria.getKeyword(), searchCriteria.getLocation(), searchCriteria.getSkills());
    }
}

