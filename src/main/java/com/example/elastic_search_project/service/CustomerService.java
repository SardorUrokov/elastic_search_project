package com.example.elastic_search_project.service;

import com.example.elastic_search_project.document.Customer;
import com.example.elastic_search_project.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(final List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(null);
    }

    public List<Customer> findByFullName(String fullName){
        return customerRepository.findByFullName(fullName);
    }

    public List<Customer> findAll(){
        return (List<Customer>) customerRepository.findAll(Sort.by("fullName"));
    }
}
