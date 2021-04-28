package com.luis.javaspringbootcrud.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luis.javaspringbootcrud.domain.Student;
import com.luis.javaspringbootcrud.form.StudentForm;
import com.luis.javaspringbootcrud.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student find(Integer id) {
		Optional<Student> obj = repo.findById(id);
		return obj.orElseThrow(() -> new EntityNotFoundException("Id not Found" + id));
	}
	
	public List<Student> findAll() {
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch
			(DataIntegrityViolationException e) {
			
	}
	}
		
	public Student insert(Student obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Student update(Integer id, StudentForm studentForm) {
		Student obj = repo.getOne(id);
		
		obj.setName(studentForm.getName());
		obj.setSurname(studentForm.getSurname());
		obj.setBirthDay(studentForm.getBirthDay());
		obj.setStudentClass(studentForm.getStudentClass());
		obj = repo.save(obj);
		return obj;
	}
	}
