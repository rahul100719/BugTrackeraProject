package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Issue;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.services.IssueService;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

/**/
@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class IssuesController {

	@Autowired
	IssueService service;

	@GetMapping(path = "/issues")
	public List<Issue> getAllIssues(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
//	log.info("Request recieved to fetch all issues");
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return this.service.findAllIssues(pageable);

	}

	@GetMapping(path = "/issues/priority/{priority}")
	public List<Issue> getIssueByPriority(@PathVariable("priority") String priority,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
//		log.info("Request recieved to fetch issues with priority : " + priority);
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return this.service.findByPriority(priority, pageable);
	}

	@GetMapping(path = "/issues/ticketId/{id}")
	public Issue getIssueById(@PathVariable("id") int id) throws EntityNotFoundException {

//		log.info("Request recieved to fetch issue with id : " + id);
		Optional<Issue> issue = service.findIssueById(id);
		if (issue.isPresent()) {
			return issue.get();
		}

		else {
//			log.error(String.format("Issue with ticket id %s not present", id));
			throw new EntityNotFoundException(String.format("Issue with ticket id %s not present", id));
		}
	}

	@PostMapping(path = "/issues")
	public ResponseEntity<Object> addIssues(@RequestBody Issue issue) {
//		log.info("Adding new issue with issue id " + issue.getId());
		this.service.addIssue(issue);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(issue, responseHeaders, HttpStatus.CREATED);
	}
}
