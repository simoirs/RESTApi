package com.RESTApi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String username;
	private LocalDate dateJoined;
	@JsonIgnore
	@ManyToMany (cascade= CascadeType.ALL)
	@JoinTable(
			name="jobApplication_user",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="jobApplication_id"))
	private List<JobApplication> jobApplications;
	
	public User() {}

	public User(String username, LocalDate dateJoined) {
		super();
		this.username = username;
		this.dateJoined = dateJoined;
		this.jobApplications = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	public List<JobApplication> getApplications() {
		return jobApplications;
	}

	public void setApplications(List<JobApplication> applications) {
		this.jobApplications = applications;
	}
	
	
	
}
