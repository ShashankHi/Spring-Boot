package com.vc.hospitalmanagement.controller;

import java.time.LocalDate;
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

import com.vc.hospitalmanagement.model.Appointment;
import com.vc.hospitalmanagement.service.AppointmentService;

@RestController
@RequestMapping("appointment/api/v1")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/insertApo")
	Appointment saveAppointmentInfo(@RequestBody Appointment appointment) {
		return appointmentService.saveAppointment(appointment);
	}
	
	@GetMapping("/getApById/{appointmentId}")
	Appointment getApById(@PathVariable Integer appointmentId) {
		return appointmentService.findByAppointmentId(appointmentId);
	}
	
	@GetMapping("/getApByDocId/{doctorId}")
	List<Appointment> getApByDocId(@PathVariable Integer doctorId){
		return appointmentService.findByDoctorId(doctorId);
	}
	
	@GetMapping("/getApByPatId/{patientId}")
	List<Appointment> getApByPatId(@PathVariable Integer patientId){
		return appointmentService.findByPatientId(patientId);
	}
	
	@GetMapping("/getByDt/{appointmentDate}")
	List<Appointment> getApByDate(@PathVariable LocalDate appointmentDate){
		return appointmentService.findByDate(appointmentDate);
	}
	
	@GetMapping("/getApBySt/{status}")
	List<Appointment> getByst(@PathVariable String status){
		return appointmentService.findByStatus(status);
	}
	
	@PutMapping("/upAppById/{appointmentId}")
	Appointment updateAppById(@PathVariable Integer appointmentId, @RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(appointmentId, appointment);
	}
	
	@DeleteMapping("/delAppById/{appointmentId}")
	String deleteAppById(@PathVariable Integer appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
		return "Appointment Deleted Successfully!!";
	}
	
}
