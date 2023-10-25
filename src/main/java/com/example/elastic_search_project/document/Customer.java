package com.example.elastic_search_project.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "customer")
public class Customer {

    private int id;
    private String fullName, phoneNumber;

}