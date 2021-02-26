package com.cap.capspringwebjpabatch2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException{

	public CategoryAlreadyExistsException(){
		
	}
	public CategoryAlreadyExistsException(String str){
		super(str);
	}
}
