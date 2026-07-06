package com.vc.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vc.hospitalmanagement.model.Hospital;
import com.vc.hospitalmanagement.service.HospitalService;

//http://localhost:9988/api/v1
@RestController
@RequestMapping("hospital/api/v1")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/insertHos")
	public Hospital saveHospitalInfo(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@GetMapping("/getListOfHos")
	public List<Hospital> getAllHos(){
		return hospitalService.getListOfHos();
	}
	
	@GetMapping("/getHosById/{hospitalId}")
	public Hospital getByHosId(@PathVariable Integer hospitalId){
		return hospitalService.getHosById(hospitalId);
	}
	
	@GetMapping("/getHosByLoc/{location}")
	public List<Hospital> getByHosLoc(@PathVariable String location){
		return hospitalService.getByLoc(location);
	}
	
	@GetMapping("/getHosByNam/{hospitalName}")
	public Hospital getByHosName(@PathVariable String hospitalName){
		return hospitalService.getByHosName(hospitalName);
	}
	
	@PutMapping("/upHosById/{hospitalId}")
	public Hospital updateHosById(@PathVariable Integer hospitalId, @RequestBody Hospital hospital) {
		return hospitalService.updateHospital(hospitalId, hospital);
	}
	
	@DeleteMapping("/delHosById/{hospitalId}")
	public String deleteHosById(@PathVariable Integer hospitalId) {
		hospitalService.deleteHospital(hospitalId);
		return "Hospital Deleted Successfully!!";
	}

}
