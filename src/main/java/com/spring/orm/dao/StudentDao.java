package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i =  (Integer)this.hibernateTemplate.save(student);
		return i;
	
	}
	//get single data(object)
	public Student getStudent(int studentId) {
		Student student =  this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	//get all student ()all
	public List<Student> getAllStudent() {
	List<Student> students = this.hibernateTemplate.loadAll(Student.class);
	return students;
	}
	
	//deleteing the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student =  this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//update data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
	
	
	
}