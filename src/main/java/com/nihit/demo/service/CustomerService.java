package com.nihit.demo.service;

import java.util.List;
import java.util.stream.Stream;

import com.nihit.demo.model.Customer;

public interface CustomerService {
public abstract Customer createCustomer(Customer customer);
public abstract List<Customer> getCustomer();
public abstract void updateCustomer(String email, Customer customer);
public abstract void deleteCustomer(String email);
public abstract Stream<Customer> searchCustomer(String firstLetterofName);
//public abstract List<Customer> searchCustomerByName(String firstName);
}
