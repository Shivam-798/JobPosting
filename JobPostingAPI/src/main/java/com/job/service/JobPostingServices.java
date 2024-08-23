package com.job.service;

import com.job.model.JobPosting;
import java.util.*;

public interface JobPostingServices {

	JobPosting createJobPosting(JobPosting jobPosting);
	
	List<JobPosting> getAllJobPosting();
	
	Optional<JobPosting> getJobPostingById(Long id);
	
	JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails);
	
	void deleteJobPosting(Long id);
	
	List<JobPosting> searchJobPosting(String keyword, String location, String skills);
}
