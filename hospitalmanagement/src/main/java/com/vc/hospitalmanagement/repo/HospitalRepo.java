package com.vc.hospitalmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vc.hospitalmanagement.model.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Integer>{
	
	List<Hospital> findByLocation(String location);
	
	List<Hospital> findByHospitalNameContaining(String hospitalName);
	
	Hospital findByHospitalName(String hospitalName);
	
}
