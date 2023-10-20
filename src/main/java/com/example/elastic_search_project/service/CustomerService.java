package com.example.elastic_search_project.service;

import java.util.List;

import com.example.elastic_search_project.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.elastic_search_project.document.Customer;
import com.example.elastic_search_project.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customer_id", id));
    }

    public Customer updateCustomer(Customer customer1, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        customer.setFullName(customer1.getFullName());
        customer.setPhoneNumber(customer1.getPhoneNumber());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

}
