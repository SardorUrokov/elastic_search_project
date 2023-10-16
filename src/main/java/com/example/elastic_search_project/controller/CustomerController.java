package com.example.elastic_search_project.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.elastic_search_project.document.Customer;
import com.example.elastic_search_project.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public void saveCustomer(@RequestBody List<Customer> customers) {
        customerService.save(customers);
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping({"/{id}"})
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/findByFullName/{fullName}")
    public List<Customer> findByFullName(@PathVariable String fullName) {
        return customerService.findByFullName(fullName);
    }

}
