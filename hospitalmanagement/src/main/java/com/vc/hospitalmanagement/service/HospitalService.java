package com.vc.hospitalmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vc.hospitalmanagement.model.Hospital;

@Service
public interface HospitalService {
	
	public abstract Hospital saveHospital(Hospital hospital);
	
	public abstract List<Hospital> getListOfHos();
	
	public abstract Hospital getHosById(Integer hospitalId);
	
	public abstract List<Hospital> getByLoc(String location);
	
	public abstract Hospital getByHosName(String hospitalName);
	
	public abstract Hospital updateHospital(Integer hospitalId, Hospital hospital);
	
	public abstract void deleteHospital(Integer hospitalId);
	
	

}
