package com.cap.capspringwebjpabatch2.controllers;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException() {
		
	}
	
	public UserAlreadyExistsException(String str) {
		super(str);
	}
}
