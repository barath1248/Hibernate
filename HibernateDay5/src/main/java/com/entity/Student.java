package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="student_details")
public class Student {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private int id;
	 
	 @Column(name="student_name")
	 private String name;
	 
	 @Column(name="qualification")
	 private String degree;
}
