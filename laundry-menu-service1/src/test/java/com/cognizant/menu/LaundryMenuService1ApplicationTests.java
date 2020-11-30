package com.cognizant.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.menu.exception.LaundryServiceNotFoundException;
import com.cognizant.menu.model.LaundryModel;
import com.cognizant.menu.repository.LaundryRepository;
import com.cognizant.menu.service.LaundryService;

@RunWith(SpringRunner.class)
@SpringBootTest
class LaundryMenuService1ApplicationTests {

	@MockBean
	private LaundryRepository lrepo;
	
	@Autowired
	private LaundryService lservice;
	
	@Test
	public void getAllServiceTest() {
		when(lrepo.findAll())
		.thenReturn((Stream.of(new LaundryModel(101,"Shirt","Wash",20)).collect(Collectors.toList())));
		assertEquals(1, lservice.getAllDetails().size());
	}
	
	@Test
	public void getServiceByIdTest() {
		final int id = 101;
		final LaundryModel lm = new LaundryModel(101,"Shirt","Wash",20);
		
		when(lrepo.findById(id))
		.thenReturn(Optional.of(lm));
		final Optional<LaundryModel> l = lservice.getServiceById(id);
		assertThat(l).isNotNull();
	}
	
	@Test
	public void saveUserTest() {
		LaundryModel lm = new LaundryModel(105,"Saree","Wash",40);
		when(lrepo.save(lm)).thenReturn(lm);
		assertEquals("Service Created", lservice.addService(lm));
	}
	@Test
	public void deleteServiceTest() throws LaundryServiceNotFoundException, Exception {
		LaundryModel lm = new LaundryModel(102,"Pant","Wash",20);
		lrepo.delete(lm);
		verify(lrepo,times(1)).delete(lm);
		
	}
	
	@Test
	public void updateServiceTest() throws LaundryServiceNotFoundException {
		LaundryModel lm = new LaundryModel(101,"Shirt","Wash",20);
		int id = 101;
		when(lrepo.getOne(101)).thenReturn(lm);
		LaundryModel lm2 = new LaundryModel();
		LaundryModel lmodel =lrepo.getOne(lm.getServiceId());
		lm2.setServiceId(lm.getServiceId());
		lm2.setProductName(lm.getProductName());
		lm2.setServiceType(lm.getServiceType());
		lm2.setPrice(lm.getPrice());
		when(lrepo.save(lm)).thenReturn(lm);
		assertEquals("Update Success", lservice.updateService(id,lm));
	}

}
