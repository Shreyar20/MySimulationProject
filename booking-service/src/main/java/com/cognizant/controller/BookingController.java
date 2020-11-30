package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.BookingServiceNotFoundException;
import com.cognizant.feignclient.Laundryfeign;
import com.cognizant.model.BookingModel;
import com.cognizant.model.LaundryModel;
import com.cognizant.repository.BookingRepository;
import com.cognizant.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bservice;
	
//	@Autowired
//	private Laundryfeign lfeign;
	
//	@Autowired
//	private BookingRepository br;
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}
	
	@GetMapping("/details")
	public List<BookingModel> getAllBooking(){
		
		return bservice.getAllBooking();
	}
	
	@PostMapping("/addnew")
	public String saveRecord(@RequestBody BookingModel bm) {
		return bservice.saveRecord(bm);
	}
	
	@GetMapping("/getbookingbyuser/{id}")
	public List<BookingModel> getBookingByUserId(@PathVariable long id) throws BookingServiceNotFoundException{
		return bservice.getBookingByUserId(id);
	}
//	@GetMapping("/userdetails")
//	public List<UserModel> getAllUser(){
//		return bservice.getAlluserList();
//	}
	
	@GetMapping("/servicedetails")
	public List<LaundryModel> getAllService(){
		return bservice.getAllServices();
	}

	@DeleteMapping("/bookingdelivered/{id}")
	public String deleteBooking(@PathVariable long id) throws BookingServiceNotFoundException {
		return bservice.deleteBooking(id);
	}
	
	@GetMapping("/totalamountofuser/{id}")
	public double getTotalPrice(@PathVariable long id) throws BookingServiceNotFoundException {
		return bservice.getTotalAmountOfUser(id);
	}
}
