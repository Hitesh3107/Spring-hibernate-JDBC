package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.StudentDAO;
import com.example.model.Student;

public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDAO dao = context.getBean(StudentDAO.class);
		
		dao.addStudent(new Student(1, "Rakesh", "11"));
		dao.addStudent(new Student(2, "Dan", "22"));
		dao.addStudent(new Student(3, "Foo", "33"));
		
		List<Student> sts = dao.getStudents();

		for (Student s : sts) {
			System.out.println(s);
		}

	}

}
