package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
	public List <Student> GetStudents(){
return List.of(
	new Student(1L,"marwan",21,"maro@gmial.com",LocalDate.of(2003,Month.MARCH,15))
);
	}
}
