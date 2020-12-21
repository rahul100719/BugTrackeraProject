package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.example.demo.entities.Issue;
import com.example.demo.repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
	IssueRepository repository;

	public List<Issue> findAllIssues(Pageable pageable) {

		Page<Issue> page = this.repository.findAll(pageable);
		return page.getContent();
	}

	public List<Issue> findByAssignedTo(String assignedTo) {
		return this.repository.findByAssignedToTeam(assignedTo);
	}

	public List<Issue> findByPriority(String priority, Pageable pageable) {
		Page<Issue> page = this.repository.findByPriority(priority, pageable);
		return page.getContent();
	}

	public void addIssue(Issue issue) {
		this.repository.save(issue);
	}

	public Optional<Issue> findIssueById(int id) {
		return this.repository.findById(id);
	}
}
