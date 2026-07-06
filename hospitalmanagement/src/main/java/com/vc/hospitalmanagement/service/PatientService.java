package com.vc.hospitalmanagement.service;

import java.util.List;

import com.vc.hospitalmanagement.model.Patient;

public interface PatientService {
	
	public abstract Patient savePatient(Patient patient);
	
	public abstract Patient getPatientById(Integer patientId);
	
	public abstract List<Patient> getPatientsByName(String patientName);
	
	public abstract Patient getPatientByPh(String phone);
	
	public abstract Patient updatePatient(Integer patientId, Patient patient);

	public abstract void deletePatient(Integer patientId);
}
