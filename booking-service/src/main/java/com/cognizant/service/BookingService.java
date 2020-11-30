package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.BookingServiceNotFoundException;
import com.cognizant.feignclient.Laundryfeign;
import com.cognizant.model.BookingModel;
import com.cognizant.model.LaundryModel;
import com.cognizant.repository.BookingRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingService {
	
	@Autowired
	private BookingRepository brepo;
	
	@Autowired
	private Laundryfeign lfeign;
	

	
	@Transactional
	public List<BookingModel> getAllBooking(){
		return brepo.findAll();
	}
	
	//public List<BookingModel> get


	@Transactional
	public String saveRecord(BookingModel bm) {

		int price = lfeign.getPriceFromService(bm.getServiceId());
		bm.setTotal(price * bm.getQuantity());
		brepo.save(bm); 
		return "Booking Created";
	}

	@Transactional
	public List<LaundryModel> getAllServices() {
		return lfeign.getAll();
	}
	
	@Transactional
	public List<BookingModel> getBookingByUserId(long id) throws BookingServiceNotFoundException{
		List<BookingModel> bm = brepo.findByuserId(id);
		if(bm == null) {
			throw new BookingServiceNotFoundException("No Booking Exist");
		}
		return bm;
	}
	
	@Transactional
	public String deleteBooking(long id) throws BookingServiceNotFoundException {
		List<BookingModel> bm = getBookingByUserId(id);
		if(bm.isEmpty()) {
			throw new BookingServiceNotFoundException("No Booking Present");
		}
		for(BookingModel b: bm) {
			brepo.delete(b);
		}
		return "Service Provided and Removed Booking";
		
	}
	
	@Transactional
	public double getTotalAmountOfUser(long id) throws BookingServiceNotFoundException {
		List<BookingModel> bm = getBookingByUserId(id);
		if(bm.isEmpty()) {
			throw new BookingServiceNotFoundException("No Booking Present");
		}
		double totalprice = 0;
		for(BookingModel b: bm) {
			totalprice = totalprice + b.getTotal();
		}
		
		return totalprice;
	}

}
