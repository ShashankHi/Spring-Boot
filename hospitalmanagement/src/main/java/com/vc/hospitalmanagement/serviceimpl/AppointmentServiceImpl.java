package com.vc.hospitalmanagement.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.hospitalmanagement.model.Appointment;
import com.vc.hospitalmanagement.repo.AppointmentRepo;
import com.vc.hospitalmanagement.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepo appointmentRepo;
	
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	@Override
	public Appointment findByAppointmentId(Integer appointmentId) {
		return appointmentRepo.findById(appointmentId).orElseThrow();
	}

	@Override
	public List<Appointment> findByDate(LocalDate appointmentDate) {
		return appointmentRepo.findByAppointmentDate(appointmentDate);
	}

	@Override
	public List<Appointment> findByStatus(String status) {
		return appointmentRepo.findByStatus(status);
	}

	@Override
	public List<Appointment> findByDoctorId(Integer doctorId) {
		return appointmentRepo.findByDoctorDoctorId(doctorId);
	}

	@Override
	public List<Appointment> findByPatientId(Integer patientId) {
		return appointmentRepo.findByPatientPatientId(patientId);
	}

	@Override
	public Appointment updateAppointment(Integer appointmentId, Appointment appointment) {
		Appointment ap = appointmentRepo.findById(appointmentId).orElseThrow();
		ap.setAppointmentDate(appointment.getAppointmentDate());
		ap.setStatus(appointment.getStatus());
		return appointmentRepo.save(ap);
	}

	@Override
	public void deleteAppointment(Integer appointmentId) {
		appointmentRepo.delete(findByAppointmentId(appointmentId));
	}

}
