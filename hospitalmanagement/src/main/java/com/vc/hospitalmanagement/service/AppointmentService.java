package com.vc.hospitalmanagement.service;

import java.time.LocalDate;
import java.util.List;

import com.vc.hospitalmanagement.model.Appointment;

public interface AppointmentService {
	
	public abstract Appointment saveAppointment(Appointment appointment);
	
	public abstract Appointment findByAppointmentId(Integer appointmentId);
	
	public abstract List<Appointment> findByDate(LocalDate appointmentDate);
	
	public abstract List<Appointment> findByStatus(String status);
	
	public abstract List<Appointment> findByDoctorId(Integer doctorId);
	
	public abstract List<Appointment> findByPatientId(Integer patientId);
	
	public abstract Appointment updateAppointment(Integer appointmentId, Appointment appointment);
	
	public abstract void deleteAppointment(Integer appointmentId);

}
