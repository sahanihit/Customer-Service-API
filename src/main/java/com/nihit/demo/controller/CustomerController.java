package com.nihit.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.nihit.demo.model.Customer;
import com.nihit.demo.service.CustomerServiceImplementation;

@RestController
public class CustomerController {
	
	
	
	@Autowired
	CustomerServiceImplementation custom;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("home.jsp");
		return mv;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Object> addDetails(Customer customer) {
		 custom.createCustomer(customer);
		return new ResponseEntity<>("Customer created", HttpStatus.OK);
	}

	@GetMapping("/customers")
	 public ResponseEntity<Object> getCustomers() {
	      return new ResponseEntity<>(custom.getCustomer(), HttpStatus.OK);
	   }
	
	@PutMapping("/customer/{firstName}")
	public ResponseEntity<Object> upCustomer(@PathVariable("firstName") String firstName, Customer customer ){
		custom.updateCustomer(firstName,customer);
		return new ResponseEntity<>("Customer details updated", HttpStatus.OK);
	}
	
	@DeleteMapping("customer/{firstName}")
	 public ResponseEntity<Object> delCustomers(@PathVariable("firstName") String firstName) {
		custom.deleteCustomer(firstName);
	      return new ResponseEntity<>("Customer removed", HttpStatus.OK);
	   }
	
	// We are searching for the person name with its first letter
	// using the Stream API
	@GetMapping("customerSearch/{firstLetterofName}")
	public ResponseEntity<Object> search(@PathVariable("firstLetterofName") String firstLetterofName) {
	      return new ResponseEntity<>(custom.searchCustomer(firstLetterofName), HttpStatus.OK);
	   }
	

	//public ResponseEntity<Object> searchbyname(@PathVariable("firstName") String firstName) {
	  //    return new ResponseEntity<>(custom.searchCustomerByName(firstName), HttpStatus.OK);
	   //}
	
	/*@PostMapping("/addDetails")
	public ModelAndView addDetails(Customer customer) {
		ModelAndView mv =new ModelAndView();
		if(customerRepo.existsById(customer.getFirstName())) {
			mv.addObject("myString","Already signed up");
			mv.setViewName("Already.jsp");
		}else {
			customerRepo.save(customer);
			mv.setViewName("welcome.jsp");
		}
		return mv;
	}*/
}
