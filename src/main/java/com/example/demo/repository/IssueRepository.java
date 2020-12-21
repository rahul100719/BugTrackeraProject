package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Issue;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/*
 * Repositry which helps in interacting with Issue Entity 
 * **/
@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

	List<Issue> findByAssignedToTeam(String assignedTo);

	Page<Issue> findByPriority(String priority, Pageable pageable);

}
