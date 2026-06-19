package com.vcube.newapi01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.newapi01.model.Student;
import com.vcube.newapi01.repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo stRepo;

	// http://localhost:9988/insertStudent
	@PostMapping("/insertStudent")
	Student insertStudent(@RequestBody Student student) {
		return stRepo.save(student);
	}
	
	//http://localhost:9988/stList
	@GetMapping("/stList")
	List<Student> getStudentList() {
		return stRepo.findAll();
	}
	
	//http://localhost:9988/stById/1
	@GetMapping("/stById/{id}")
	Student getStudentById(@PathVariable Integer id) {
		return stRepo.findById(id).orElseThrow();
	}
	
	//http://localhost:9988/getStByPh/8328572223
	@GetMapping("/getStByPh/{phone}")
	Student getStudentByPhone(@PathVariable long phone) {
		return stRepo.findByPhone(phone);
	}
	
	//http://localhost:9988/updateSt/2
	@PutMapping("/updateSt/{id}")
	Student updateStudent(@RequestBody Student student,@PathVariable Integer id) {
		Student st = stRepo.findById(id).orElseThrow();
		st.setSname(student.getSname());
		st.setAge(student.getAge());
		st.setPhone(student.getPhone());
		
		return stRepo.save(st);
	}
	
	//http://localhost:9988/updateStPh/1
	@PatchMapping("/updateStPh/{id}")
	Student getStudentPhone(@RequestBody Student student, @PathVariable Integer id) {
		Student st = stRepo.findById(id).orElseThrow();
		
		st.setPhone(student.getPhone());
		return stRepo.save(st);
		
	}
	
	//http://localhost:9988/deleteStById/1
	@DeleteMapping("/deleteStById/{id}") 
	String deleteStudentById(@PathVariable Integer id) {
		stRepo.deleteById(id);
		return "Student Deleted Succesfully!!";
	}

}
