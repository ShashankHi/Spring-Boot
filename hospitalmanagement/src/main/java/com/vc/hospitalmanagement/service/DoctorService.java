package com.vc.hospitalmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vc.hospitalmanagement.model.Doctor;

@Service
public interface DoctorService {
	
	public abstract Doctor saveDoctor(Doctor doctor);
	
	public abstract List<Doctor> getAllDoctorsList();
	
	public abstract Doctor getDoctorById(Integer doctorId);
	
	public abstract List<Doctor> findByHospitalHospitalId(Integer hospitalId);
	
	public abstract List<Doctor> findBySpecialization(String specialization);
	
	public abstract List<Doctor> findByDoctorNameContaining(String doctorName);
	
	public abstract Doctor updateDoctor(Integer doctorId, Doctor doctor);
	
	public abstract void deleteDoctor(Integer doctorId);
	
}
