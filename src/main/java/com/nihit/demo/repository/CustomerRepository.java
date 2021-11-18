package com.nihit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nihit.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	
	//@Query("Select c from customer c where c.first_Name = :firstname")
	//public List<Customer> searchByName(@Param("firstname") String firstname);
}
