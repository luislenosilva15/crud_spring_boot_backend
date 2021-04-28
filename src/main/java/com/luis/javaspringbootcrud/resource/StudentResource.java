package com.luis.javaspringbootcrud.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luis.javaspringbootcrud.domain.Student;
import com.luis.javaspringbootcrud.form.StudentForm;
import com.luis.javaspringbootcrud.service.StudentService;

@RestController
@RequestMapping(value="/students")
public class StudentResource {
	
	@Autowired
	private StudentService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Student obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> findAll() {
		List<Student> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}",  method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid StudentForm studentForm, @PathVariable Integer id) {
		service.update(id, studentForm);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> Insert(@Valid @RequestBody Student obj){
		obj = service.insert(obj);
		return null;
	}
	}
	
