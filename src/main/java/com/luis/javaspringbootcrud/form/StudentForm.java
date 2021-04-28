package com.luis.javaspringbootcrud.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentForm {
	
	private String name;
	private String surname;
	private String studentClass;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date birthDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	
}
