package com.cognizant.menu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menu.exception.LaundryServiceNotFoundException;
import com.cognizant.menu.model.LaundryModel;
import com.cognizant.menu.service.LaundryService;

@RestController
@RequestMapping("/laundryService")
public class LaundryController {

	@Autowired
	private LaundryService lService;
	

	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}
	
	@GetMapping("/details")
	public List<LaundryModel> getAllServices(){
		return lService.getAllDetails();
		
	}
	
	@PostMapping("/addnew")
	public String addService(@RequestBody LaundryModel lm) {
		return lService.addService(lm);
	}

	@GetMapping("/getprice/{id}")
	public int getPriceFromService(@PathVariable(value = "id") int id) throws LaundryServiceNotFoundException{
		return lService.getPriceFromService(id);
	}
	
	@GetMapping("/getServiceById/{id}")
	public Optional<LaundryModel> getServiceById(@PathVariable int id) {
		System.out.println("======================================================================================================================================");
		return lService.getServiceById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateService(@PathVariable int id, @RequestBody LaundryModel lm) throws LaundryServiceNotFoundException {
		return lService.updateService(id,lm);
	}
//	
	@DeleteMapping("/deleteservice/{id}")
	public String deleteService(@PathVariable(value = "id")int id) throws LaundryServiceNotFoundException{
		return lService.deleteService(id);
	}
}

