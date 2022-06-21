package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.jdbc.core.RowMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
public @Data @AllArgsConstructor @NoArgsConstructor class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "roll")
	private String roll;

	public static class StudentMapper implements RowMapper<Student> {

		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student st = new Student();
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			st.setRoll(rs.getString("rollno"));
			return st;
		}

	}

}
