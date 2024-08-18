package com.zohaib.swagger;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class Student {
    @PrimaryKey
    private Long id;
    private String name;
    @NotNull
    private Integer age;


}
