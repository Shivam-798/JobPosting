package com.job.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.model.JobPosting;
import com.job.repository.JobPostingRepository;
import com.job.service.JobPostingServices;

@Service
public class JobPostingServicesImplementation implements JobPostingServices {

	@Autowired
	private JobPostingRepository jobPostingRepository;
	
	@Override
	public JobPosting createJobPosting(JobPosting jobPosting) {
		// TODO Auto-generated method stub
        return jobPostingRepository.save(jobPosting);
	}

	@Override
	public List<JobPosting> getAllJobPosting() {
		// TODO Auto-generated method stub
        return jobPostingRepository.findAll();
	}

	@Override
	public Optional<JobPosting> getJobPostingById(Long id) {
		// TODO Auto-generated method stub
        return jobPostingRepository.findById(id);
	}

	@Override
	public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
		JobPosting jobPosting = jobPostingRepository.findById(id).orElseThrow(() -> new RuntimeException("Job posting not found"));
        jobPosting.setTitle(jobPostingDetails.getTitle());
        jobPosting.setDescription(jobPostingDetails.getDescription());
        jobPosting.setLocation(jobPostingDetails.getLocation());
        jobPosting.setCompany(jobPostingDetails.getCompany());
        jobPosting.setSalaryRange(jobPostingDetails.getSalaryRange());
        jobPosting.setRequiredSkills(jobPostingDetails.getRequiredSkills());
        jobPosting.setApplicationDeadline(jobPostingDetails.getApplicationDeadline());
        return jobPostingRepository.save(jobPosting);
	}

	@Override
	public void deleteJobPosting(Long id) {
		// TODO Auto-generated method stub
	jobPostingRepository.deleteById(id);


	}

	@Override
	public List<JobPosting> searchJobPosting(String keyword, String location, String skills) {
		// TODO Auto-generated method stub
        return jobPostingRepository.findByTitleContainingOrLocationContainingOrRequiredSkillsContaining(keyword, location, skills);
	}

}
