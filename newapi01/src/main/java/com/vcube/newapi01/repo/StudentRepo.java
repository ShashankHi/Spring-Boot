package com.vcube.newapi01.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.newapi01.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public abstract Student findByPhone(long phone);

}
