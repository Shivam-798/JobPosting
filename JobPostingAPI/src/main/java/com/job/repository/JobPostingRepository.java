package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.model.JobPosting;
import java.util.*;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByTitleContainingOrLocationContainingOrRequiredSkillsContaining(String title, String location, String requiredSkills);
}