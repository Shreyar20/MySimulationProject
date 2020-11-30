package com.cognizant.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class LaundryServiceNotFoundException extends Exception {

	public LaundryServiceNotFoundException(long id) {
		super(id+" This service is not available.");
	}

	public LaundryServiceNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
