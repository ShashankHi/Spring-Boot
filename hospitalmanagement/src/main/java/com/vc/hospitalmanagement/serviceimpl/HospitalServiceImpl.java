package com.vc.hospitalmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vc.hospitalmanagement.exceptionhandling.ResourceNotFoundException;
import com.vc.hospitalmanagement.model.Hospital;
import com.vc.hospitalmanagement.repo.HospitalRepo;
import com.vc.hospitalmanagement.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	HospitalRepo hospitalRepo;

	@Override
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	@Override
	public List<Hospital> getListOfHos() {
		return hospitalRepo.findAll();
	}

	@Override
	public Hospital getHosById(Integer hospitalId) {
		return hospitalRepo.findById(hospitalId).orElseThrow(
				() -> new ResourceNotFoundException("Hospital Not Found"));
	}

	@Override
	public List<Hospital> getByLoc(String location) {
		return hospitalRepo.findByLocation(location);
	}

	@Override
	public Hospital getByHosName(String hospitalName) {
		return hospitalRepo.findByHospitalName(hospitalName);
	}

	@Override
	public Hospital updateHospital(Integer hospitalId, Hospital hospital) {
		Hospital hs = hospitalRepo.findById(hospitalId).orElseThrow();
		hs.setHospitalName(hospital.getHospitalName());
		hs.setLocation(hospital.getLocation());
		return hospitalRepo.save(hs);
	}

	@Override
	public void deleteHospital(Integer hospitalId) {
		hospitalRepo.delete(getHosById(hospitalId));
	}
	
	

}
