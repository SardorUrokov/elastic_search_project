package com.example.elastic_search_project.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "customer")
public class Customer {

    @Id
    @Field(type = FieldType.Keyword)
    private Long id;

    private String fullName;
    private int phoneNumber;

}