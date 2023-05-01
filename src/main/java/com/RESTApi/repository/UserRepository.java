package com.RESTApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RESTApi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
