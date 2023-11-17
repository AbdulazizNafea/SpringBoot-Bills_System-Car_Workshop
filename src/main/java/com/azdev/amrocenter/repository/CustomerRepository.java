package com.azdev.amrocenter.repository;

import com.azdev.amrocenter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
    Customer findCustomersByPhone(String phone);
    Customer findCustomersByBillId(Integer id);


}
