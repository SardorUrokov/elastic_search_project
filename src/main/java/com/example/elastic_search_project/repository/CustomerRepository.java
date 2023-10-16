package com.example.elastic_search_project.repository;

import com.example.elastic_search_project.document.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, Long> {

    List<Customer> findByFullName(String fullName);

}
