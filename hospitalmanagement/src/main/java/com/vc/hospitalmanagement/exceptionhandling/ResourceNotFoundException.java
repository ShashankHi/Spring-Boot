package com.vc.hospitalmanagement.exceptionhandling;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
