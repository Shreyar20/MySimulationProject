package com.cognizant.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookingServiceNotFoundException extends Exception {

	public BookingServiceNotFoundException(long id) {
		super(id+" this booking is not found");
	}
}
