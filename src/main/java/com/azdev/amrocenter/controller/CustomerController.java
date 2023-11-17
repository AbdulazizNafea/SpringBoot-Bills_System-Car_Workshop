package com.azdev.amrocenter.controller;


import com.azdev.amrocenter.model.Bill;
//import com.azdev.amrocenter.model.Car;
import com.azdev.amrocenter.model.Customer;
import com.azdev.amrocenter.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCustomer(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(customerService.getCustomer(id));
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        customerService.updateCustomer(customer, id);
        return ResponseEntity.status(200).body("Customer updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        return ResponseEntity.status(200).body("deleted");
    }

//    @PostMapping("/addCar/{customerId}")
//    public ResponseEntity assignPart(@PathVariable Integer customerId, @RequestBody @Valid Car car) {
//        customerService.assignCarToCustomer(customerId, car);
//        return ResponseEntity.status(200).body("Car added to customer");
//    }

}


