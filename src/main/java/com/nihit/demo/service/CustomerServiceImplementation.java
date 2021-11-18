package com.nihit.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihit.demo.model.Customer;
import com.nihit.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepository custRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer cust = custRepo.save(customer);
		return cust;
	}

	@Override
	public List<Customer> getCustomer() {
		List<Customer> cst = custRepo.findAll();

		// cst.forEach(cs -> {System.out.println(cst);});//Lambda Expression

		/**
		 * cst.stream().filter(cs -> { return cs.getFirstName().startsWith("N");
		 * }).forEach(System.out::println);
		 */

		return custRepo.findAll();
	}

	@Override
	public void updateCustomer(String firstName, Customer customer) {
		custRepo.deleteById(firstName);
		custRepo.save(customer);
	}

	@Override
	public void deleteCustomer(String firstName) {
		custRepo.deleteById(firstName);

	}

	@Override
	public Stream<Customer> searchCustomer(String firstLetterofName) {
		List<Customer> cst = custRepo.findAll();

		// returning the values in the Stream
		Stream<Customer> res = cst.stream().filter(cs -> {
			return cs.getFirstName().startsWith(firstLetterofName);// returning in the Stream
		});
		
		//returning the values in the list
		//List<Customer> result = custRepo.findAll().parallelStream().filter(cs -> 
		//{return cs.getFirstName().startsWith(firstLetterofName);})
		//.collect(Collectors.toList());

		return res;
	}

	//@Override
	//public List<Customer> searchCustomerByName(String firstName) {
	//	return custRepo.searchByName(firstName);
		
	//}

	/*
	 * @Override public ModelAndView createCustomer(Customer customer) {
	 * //custRepo.save(customer); ModelAndView mv=new ModelAndView();
	 * if(custRepo.existsById(customer.getFirstName())) {
	 * //mv.setViewName("Already.jsp"); }else { custRepo.save(customer);
	 * //mv.setViewName("welcome.jsp"); } return mv; }
	 */
}
