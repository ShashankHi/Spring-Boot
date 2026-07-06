package com.vc.hospitalmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.hospitalmanagement.model.Doctor;
import com.vc.hospitalmanagement.repo.DoctorRepo;
import com.vc.hospitalmanagement.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRepo doctorRepo;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctorsList() {
		return doctorRepo.findAll();
	}

	@Override
	public List<Doctor> findByHospitalHospitalId(Integer hospitalId) {
		return doctorRepo.findByHospitalHospitalId(hospitalId);
	}

	@Override
	public List<Doctor> findBySpecialization(String specialization) {
		return doctorRepo.findBySpecialization(specialization);
	}

	@Override
	public List<Doctor> findByDoctorNameContaining(String doctorName) {
		return doctorRepo.findByDoctorNameContaining(doctorName);
	}

	@Override
	public Doctor updateDoctor(Integer doctorId, Doctor doctor) {
		Doctor dbDoctor = doctorRepo.findById(doctorId).orElseThrow();
		dbDoctor.setDoctorName(doctor.getDoctorName());
		dbDoctor.setSpecialization(doctor.getSpecialization());
		return doctorRepo.save(dbDoctor);
	}

	@Override
	public Doctor getDoctorById(Integer doctorId) {
		return doctorRepo.findById(doctorId).orElseThrow();
	}

	@Override
	public void deleteDoctor(Integer doctorId) {
		doctorRepo.delete(getDoctorById(doctorId));
		
	}

}
