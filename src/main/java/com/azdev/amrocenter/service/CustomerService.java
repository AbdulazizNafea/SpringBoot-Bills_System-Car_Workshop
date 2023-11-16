package com.azdev.amrocenter.service;


import com.azdev.amrocenter.apiException.ApiException;
import com.azdev.amrocenter.model.Customer;
import com.azdev.amrocenter.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("customer not found");
        }
        return customerRepository.findCustomerById(id);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean updateCustomer(Customer customerRes, Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            return false;
        }
        customer.setName(customerRes.getName());
        customer.setPhone(customerRes.getPhone());
        customer.setTaxCode(customerRes.getTaxCode());
        customerRepository.save(customer);
        return true;
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer);
    }

}
