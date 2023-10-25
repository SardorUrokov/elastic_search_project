package com.example.elastic_search_project.service;

import com.example.elastic_search_project.ElasticSearchProjectApplication;
import lombok.RequiredArgsConstructor;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import com.example.elastic_search_project.document.Customer;
import com.example.elastic_search_project.repository.CustomerRepository;
import com.example.elastic_search_project.exceptions.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private static final Logger log = LogManager.getLogger(ElasticSearchProjectApplication.class);

    public Customer save(Customer customer) {
        final var saved = customerRepository.save(customer);
        log.info("Customer is saved {}", saved);
        return saved;
    }

    public Iterable<Customer> findAll() {
        final var customers = customerRepository.findAll();
        log.info("Getting all Customers data");
        return customers;
    }

    public Customer findById(int id) {
        final var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", id));
        log.info("Getting customer by {} id -> {}", id, customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer1, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        customer.setFullName(customer1.getFullName());
        customer.setPhoneNumber(customer1.getPhoneNumber());
        final var saved = customerRepository.save(customer);
        log.warn("Customer is updated by {} id -> {}", id, saved);
        return saved;
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
        log.warn("Customer is Deleted by {} id", id);
    }

}