package com.RESTApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RESTApi.model.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}
