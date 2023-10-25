package com.example.elastic_search_project.service;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.elastic_search_project.document.Customer;
import com.example.elastic_search_project.repository.CustomerRepository;
import com.example.elastic_search_project.exceptions.ResourceNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public Customer save(Customer customer) {
        final var saved = customerRepository.save(customer);
        logger.info("Customer is saved {}", saved);
        return saved;
    }

    public Iterable<Customer> findAll() {
        final var customers = customerRepository.findAll();
        logger.info("Getting all Customers data");
        return customers;
    }

    public Customer findById(int id) {
        final var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", id));
        logger.info("Getting customer by {} id -> {}", id, customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer1, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        customer.setFullName(customer1.getFullName());
        customer.setPhoneNumber(customer1.getPhoneNumber());
        final var saved = customerRepository.save(customer);
        logger.warn("Customer is updated by {} id -> {}", id, saved);
        return saved;
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
        log.warn("Customer is Deleted by {} id", id);
    }

}