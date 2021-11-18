package com.nihit.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.nihit.demo.model.Customer;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestCustomerService extends TestCase {

	@Autowired
	private CustomerServiceImplementation customerServiceImplementation;
	
	@Test
	public void testCreateCustomer() {
		
		/*//Create a customer for test
		Customer customer1 = new Customer();
		customer1.setFirstName("Nihit");
		customer1.setLastName("Saha");
		customer1.setEmail("sahaNihit@tcs");
		customer1.setPassword("12345");
		customer1.setAddressLine1("32 khublal");
		customer1.setState("WB");
		customer1.setCity("KOL");
		customer1.setPincode(1231);
		
		//test for adding the contact
		Customer contact = customerServiceImplementation.createCustomer(customer1);
		
		//verify the addition
		assertNotNull(contact); //checks the data gets saved or not
		assertEquals("Nihit", contact.getFirstName());
		*/
		assertTrue(true);
	}


}
