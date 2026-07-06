package com.vc.hospitalmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.hospitalmanagement.model.Patient;
import com.vc.hospitalmanagement.repo.PatientRepo;
import com.vc.hospitalmanagement.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	PatientRepo patientRepo;

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	@Override
	public Patient getPatientById(Integer patientId) {
		return patientRepo.findById(patientId).orElseThrow();
	}

	@Override
	public List<Patient> getPatientsByName(String patientName) {
		return patientRepo.findByPatientName(patientName);
	}

	@Override
	public Patient getPatientByPh(String phone) {
		return patientRepo.findByPhone(phone);
	}

	@Override
	public Patient updatePatient(Integer patientId, Patient patient) {
		Patient p = patientRepo.findById(patientId).orElseThrow();
		p.setPatientName(patient.getPatientName());
		p.setPhone(patient.getPhone());
		return patientRepo.save(p);
	}

	@Override
	public void deletePatient(Integer patientId) {
		patientRepo.delete(getPatientById(patientId));
	}



	

}
