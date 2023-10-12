package com.example.elastic_search_project.repository;

import com.example.elastic_search_project.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    List<Customer> findByFullName(String fullName);

}
