package com.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_data")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_address", length = 20)
	private String address;

	@Column(name = "emp_companyName")
	private String companyName;

	@Transient
	private String hrMail;

	@Column(name = "emp_joiningDate")
	private LocalDate joiningDate;

	@Column(name = "emp_submissionTime")
	private LocalTime projectSubmissionTime;

	@Column(name = "emp_AssignmentSubmissionData")
	private LocalDateTime projectAssignmentZone;

	@Lob
	private byte[] employeeImage;


}
