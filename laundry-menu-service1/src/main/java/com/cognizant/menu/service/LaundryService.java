package com.cognizant.menu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.menu.exception.LaundryServiceNotFoundException;
import com.cognizant.menu.model.LaundryModel;
import com.cognizant.menu.repository.LaundryRepository;

@Service
public class LaundryService {
	
	@Autowired
	private LaundryRepository lRepository;
	
	@Transactional
	public List<LaundryModel> getAllDetails(){
		return lRepository.findAll();
	}
//	
//	@Transactional
//	public Optional<LaundryModel> getOneDetails(long id) {
//		return lRepository.findById(id);
//	}
//	
	@Transactional
	public Optional<LaundryModel> getServiceById(int id) {
		Optional<LaundryModel> lm = lRepository.findById(id);
		return lm;
	}
//	
	@Transactional
	public String updateService(int id,LaundryModel lm) throws LaundryServiceNotFoundException{
		
		if(lm == null) {
			throw new LaundryServiceNotFoundException("Service Not present");
		}
		LaundryModel lModel = lRepository.getOne(id);
		lModel.setServiceId(lm.getServiceId());
		lModel.setProductName(lm.getProductName());
		lModel.setServiceType(lm.getServiceType());
		lModel.setPrice(lm.getPrice());
		lRepository.save(lModel);
		
		return "Update Success";
	}
////	
	@Transactional
	public String deleteService(int id) throws LaundryServiceNotFoundException {
		LaundryModel lm = lRepository.getOne(id);
		if(lm == null) {
			throw new LaundryServiceNotFoundException(id);
		}
		lRepository.delete(lm);
		return "Service Deleted ";
	}
//
	@Transactional
	public String addService(LaundryModel lm) {
		lRepository.save(lm);
		return "Service Created";
	}
//	
	@Transactional
	public int getPriceFromService(int id) throws LaundryServiceNotFoundException {
//		List<LaundryModel> lm =  lRepository.findByServiceId(id);
		LaundryModel lm = lRepository.getOne(id);
		int price = 0;
		if(lm != null) {
			price = lm.getPrice();
		
		}else {
			throw new LaundryServiceNotFoundException(id);
		}
		return price;
	}
	public void setLaundryBooking(LaundryRepository lrepo) {
		// TODO Auto-generated method stub
		this.lRepository = lrepo;
		
	}
	
////	@Transactional
////	public LaundryModel save(LaundryModel l) {
////		return lRepository.save(l);
////	}
//
////	@Transactional
////	public LaundryModel findById(long id) {
////		return lRepository.findById(id);
////	}
////	
////	public void delete(LaundryModel lm) {
////		lRepository.delete(lm);
////	}
	
	
	
}
