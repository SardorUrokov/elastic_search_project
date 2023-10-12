package com.example.elastic_search_project;

import com.example.elastic_search_project.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RestController
public class ElasticSearchProjectApplication {

    @Autowired
    private CustomerRepository repository;

    @PostMapping("/saveCustomer")
    public int saveCustomer(@RequestBody List<Customer> customers) {
        repository.saveAll(customers);
        return customers.size();
    }

    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/findByFullName/{fullName}")
    public List<Customer> findByFullName(@PathVariable String fullName) {
        return repository.findByFullName(fullName);
    }


    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchProjectApplication.class, args);
    }
}