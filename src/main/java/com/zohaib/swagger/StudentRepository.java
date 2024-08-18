package com.zohaib.swagger;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StudentRepository  extends CassandraRepository<Student,Long> {
}
