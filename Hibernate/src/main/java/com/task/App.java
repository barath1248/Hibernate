package com.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration();
		con.configure("com/task/hibernate-cnf.xml");
		SessionFactory Factory = con.buildSessionFactory();
		Session session = Factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = new Employee();
		emp.setName("Bharath");
		emp.setAddress("Hyd");
		emp.setCompanyName("Google");
		emp.setJoiningDate(LocalDate.of(2026, 10, 19));
		emp.setHrMail("hr@gmail.com");
		emp.setProjectSubmissionTime(LocalTime.of(9, 0));
		emp.setProjectAssignmentZone(LocalDateTime.of(2026, 10,19,9,0));
		Path path=Paths.get("D:\\Downloads\\Wallpaper.png");
		byte[] imageBytes =null;
		try {
		 imageBytes = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setEmployeeImage(imageBytes);
		session.persist(emp); 
		
       
		Employee emp1=session.get(Employee.class,202);
		byte[] employeeImage =emp1.getEmployeeImage();
		Path path1 = Paths.get("D:\\Wallpaper.png");
		try {
			Files.write(path1, employeeImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Image stored"); 
		transaction.commit();
		session.close();
	}
}
