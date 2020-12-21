package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BugTracker")
public class Issue {

	@Id
	int id;
	String assignedByTeam;
	String assignedToTeam;
	String projectCode;
	String priority;
	String description;
	Date assignedOn;

}
