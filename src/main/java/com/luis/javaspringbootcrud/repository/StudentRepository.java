package com.luis.javaspringbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.javaspringbootcrud.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
