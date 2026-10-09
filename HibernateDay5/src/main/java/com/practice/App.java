package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

import DAO.OperationDao;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> data = new ArrayList<Student>();
		while (true) {
			System.out.println("press 1 for insert ");
			System.out.println("Press 2 for fecth");
			System.out.println("Press 3 for exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Student student = null;
				System.out.println("Enter the no.of Students :");
				int num = sc.nextInt();
				for (int i = 0; i < num; i += 1) {
					System.out.println("Enter the student name");
					String name = sc.next();
					System.out.println("Enter the student degree");
					String degree = sc.next();
					student = new Student();
					student.setName(name);
					student.setDegree(degree);
					data.add(student);
				}
				String res = OperationDao.insert(data);
				System.out.println("Status :" + res);
				break;
			case 2:
				OperationDao.getData(data).forEach(System.out::println);

				break;
			case 3:
				System.out.println("Thank you !");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}
