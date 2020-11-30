package com.cognizant.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.LaundryModel;
@FeignClient(url="http://localhost:8001/laundryService",name="LaundryService")
@Service
public interface Laundryfeign {
	
	@GetMapping("/details")
	public List<LaundryModel> getAll();
	
	@GetMapping("/getServiceById/{id}")
	public List<LaundryModel> getServiceById(@PathVariable long id);
	
	@GetMapping("/getprice/{id}")
	public int getPriceFromService(@PathVariable(value = "id") long id);
}
