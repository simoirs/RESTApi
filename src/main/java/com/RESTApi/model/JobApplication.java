package com.RESTApi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="applications")
public class JobApplication {

	@Id
	@GeneratedValue
	private long id;
	private String jobDescription;
	private LocalDate dateApplied;
	@JsonIgnore
	@ManyToMany(mappedBy="jobApplications")
	private List<User> users;
	
	public JobApplication() {}

	public JobApplication(String jobDescription, LocalDate dateApplied) {
		super();
		this.jobDescription = jobDescription;
		this.dateApplied = dateApplied;
		this.users = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
