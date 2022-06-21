package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.model.Student;

@Component
@Primary
public class HibernateDAOImpl implements StudentDAO {

	@Autowired
	public SessionFactory factory;

	public List<Student> getStudents() {

		Session session = factory.openSession();
		session.beginTransaction();
		List<Student> st = session.createQuery("from Student", Student.class).getResultList();
		session.close();
		return st;
	}

	public void addStudent(Student s) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(s);
		t.commit();

		session.close();

	}

}
