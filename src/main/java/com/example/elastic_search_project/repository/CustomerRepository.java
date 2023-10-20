package com.example.elastic_search_project.repository;

import java.util.List;

import com.example.elastic_search_project.document.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, Integer> {
    List<Customer> findByFullName(String fullName);
}