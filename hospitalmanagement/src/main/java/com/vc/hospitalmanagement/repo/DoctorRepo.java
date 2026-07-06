package com.vc.hospitalmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vc.hospitalmanagement.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{
	
	List<Doctor> findByHospitalHospitalId(Integer hospitalId);
	
	List<Doctor> findBySpecialization(String specialization);
	
	List<Doctor> findByDoctorNameContaining(String doctorName);

}
