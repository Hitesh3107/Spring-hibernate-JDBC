package com.example.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.model.Student;

@Component
public class JdbcDAOImpl implements StudentDAO {

	@Autowired
	public JdbcTemplate template;

	@Autowired
	public DataSource dataSource;

	public List<Student> getStudents() {
		String sql = "select * from student";
		List<Student> st = template.query(sql, new Student.StudentMapper());

		return st;
	}

	public void addStudent(Student s) {
//		String sql = ""
//		template.update()
		
	}

}
