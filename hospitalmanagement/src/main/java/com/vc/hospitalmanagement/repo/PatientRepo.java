package com.vc.hospitalmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vc.hospitalmanagement.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer>{
	
	List<Patient> findByPatientName(String patientName);
	
	Patient findByPhone(String phone);

}
