package com.luis.javaspringbootcrud;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luis.javaspringbootcrud.domain.Student;
import com.luis.javaspringbootcrud.repository.StudentRepository;

@SpringBootApplication
public class JavaSpringbootCrudApplication implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootCrudApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Student std1 = new Student(null, "luis leno", "Silva da silva", "First class", sdf.parse("08/02/1996"));
		Student std2 = new Student(null, "luis paulo", "Silva da silva", "First class", sdf.parse("08/02/1996"));
		
		studentRepository.saveAll(Arrays.asList(std1,std2));
		
	}

	
}
