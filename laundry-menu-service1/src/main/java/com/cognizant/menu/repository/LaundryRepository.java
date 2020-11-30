package com.cognizant.menu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.menu.model.LaundryModel;

@Repository
public interface LaundryRepository extends JpaRepository<LaundryModel, Integer>{

//	@Query(value="select * from laundryservice")
//	public List<LaundryModel> findAll();
	
//	@Query(value="select l from laundryservice l where l.serviceid= ?1",nativeQuery =true)
//	public List<LaundryModel> findByServiceId(long id);

	
}
