package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student(id,name,city) values(?,?,?)";
		int res = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return res;
	}
	
	@Override
	public int change(Student student) {
		// TODO Auto-generated method stub
		String query = "update Student set name = ?, city = ? where id = ? ";
		int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return res;
	}
	
	@Override
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		String query = "delete from Student where id = ? ";
		int res = this.jdbcTemplate.update(query, studentId);
		return res;
	}
	
	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		String query = "select * from Student where id = ? ";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student res = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return res;
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String query = "select * from Student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
