package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.model.BookingModel;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Integer>{

	
	public List<BookingModel> findByuserId(long userId);

//	@Query(value="select * from booking  where userid = ?1")
//	public BookingModel findBookingByUserId(long id);
}
