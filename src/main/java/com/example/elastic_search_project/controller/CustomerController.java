package com.example.elastic_search_project.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import com.example.elastic_search_project.document.Customer;
import com.example.elastic_search_project.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping({"/{id}"})
    public Customer findById(@PathVariable int id) {
        return customerService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Customer updateById(@RequestBody Customer customer, @PathVariable Integer id) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

}
