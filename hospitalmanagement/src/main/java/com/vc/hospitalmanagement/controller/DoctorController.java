package com.vc.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vc.hospitalmanagement.model.Doctor;
import com.vc.hospitalmanagement.service.DoctorService;

@RestController
@RequestMapping("doctor/api/v1")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/insertDoc")
	Doctor saveDoctorInfo(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	@GetMapping("/getAllDoc")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctorsList();
	}
	
	@GetMapping("/getDocById/{doctorId}")
	public Doctor getDoctorById(Integer doctorId){
		return doctorService.getDoctorById(doctorId);
	}
	
	@GetMapping("/getDocByHosId/{hospitalId}")
	public List<Doctor> getDoctorsHosId(@PathVariable Integer hospitalId){
		return doctorService.findByHospitalHospitalId(hospitalId);
	}
	
	@GetMapping("/getDocBySpec/{specialization}")
	public List<Doctor> getDoctorsBySpec(@PathVariable String specialization){
		return doctorService.findBySpecialization(specialization);
	}
	
	@GetMapping("/getDocByNaCon/{doctorName}")
	public List<Doctor> getDoctorsByNameCont(@PathVariable String doctorName){
		return doctorService.findByDoctorNameContaining(doctorName);
	}
	
	@PutMapping("/upDocById/{doctorId}")
	public Doctor updateDocById(@PathVariable Integer doctorId, @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctorId, doctor);
	}
	
	@DeleteMapping("/delDocById/{doctorId}")
	public String deleteDocById(@PathVariable Integer doctorId) {
		doctorService.deleteDoctor(doctorId);
		return "Doctor Deleted Successfully";
	}
	
}
