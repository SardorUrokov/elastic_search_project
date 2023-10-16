package com.example.elastic_search_project.document;

import com.example.elastic_search_project.helper.Indices;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName= Indices.CUSTOMER_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Customer {

    @Id
    @Field(type = FieldType.Keyword)
    private Long id;

    private String fullName;
    private int phoneNumber;

}