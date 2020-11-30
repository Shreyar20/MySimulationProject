package com.cognizant.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserServiceNotFoundException extends Exception {

	public UserServiceNotFoundException(long id) {
		super(id+" this could not found.");
	}
}
