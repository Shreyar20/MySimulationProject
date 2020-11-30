package com.cognizant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.exception.BookingServiceNotFoundException;
import com.cognizant.feignclient.Laundryfeign;
import com.cognizant.model.BookingModel;
import com.cognizant.repository.BookingRepository;
import com.cognizant.service.BookingService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingServiceApplicationTests {

	@MockBean
	private Laundryfeign lfeign;
	@MockBean
	private BookingRepository brepo;
	@Autowired
	private BookingService bservice;
	
	@Test
	public void getAllBookingTest() {
		when(brepo.findAll())
		.thenReturn((Stream.of(new BookingModel(201,1,101,1,"Shirt",20)).collect(Collectors.toList())));
		assertEquals(1, bservice.getAllBooking().size());
	}
	
	@Test
	public void getBookingByUserIdTest() throws BookingServiceNotFoundException {
		final int id = 1;
		final BookingModel bm = new BookingModel(201,1,101,1,"Shirt",20);
		
		when(brepo.findByuserId(id))
		.thenReturn((Stream.of(new BookingModel(201,1,101,1,"Shirt",20)).collect(Collectors.toList())));
		final List<BookingModel> b = bservice.getBookingByUserId(id);
		assertThat(b).isNotNull();
	}
	
	@Test
	public void saveBookingTest() {
		BookingModel bm = new BookingModel(201,1,101,1,"Shirt");
		double total = lfeign.getPriceFromService(bm.getServiceId()) * bm.getQuantity();
		bm.setTotal(total);
		when(brepo.save(bm)).thenReturn(bm);
		assertEquals("Booking Created", bservice.saveRecord(bm));
	}
	
	@Test
	public void deleteBookingTest() {
		BookingModel bm = new BookingModel(201,1,101,1,"Shirt",20);
		brepo.delete(bm);
		verify(brepo,times(1)).delete(bm);
	}

}
