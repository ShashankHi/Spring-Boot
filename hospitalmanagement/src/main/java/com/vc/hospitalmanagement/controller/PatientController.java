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

import com.vc.hospitalmanagement.model.Patient;
import com.vc.hospitalmanagement.service.PatientService;

@RestController
@RequestMapping("patient/api/v1")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/insertPat")
	Patient savePatientInfo(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	
	@GetMapping("/getByPatId/{patientId}")
	Patient getByPatId(@PathVariable Integer patientId) {
		return patientService.getPatientById(patientId);
	}
	
	@GetMapping("/getByPatName/{patientName}")
	List<Patient> getByName(@PathVariable String patientName) {
		return patientService.getPatientsByName(patientName);
	}
	
	@GetMapping("/getByPatPh/{phone}")
	Patient getByPh(@PathVariable String phone) {
		return patientService.getPatientByPh(phone);
	}
	
	@PutMapping("/upPatById/{patientId}")
	Patient updatePatById(@PathVariable Integer patientId, @RequestBody Patient patient) {
		return patientService.updatePatient(patientId, patient);
	}
	
	@DeleteMapping("/delPatById/{patientId}")
	String deletePatById(@PathVariable Integer patientId) {
		patientService.deletePatient(patientId);
		return "Patient Deleted Successfully!!";
	}
	
}
