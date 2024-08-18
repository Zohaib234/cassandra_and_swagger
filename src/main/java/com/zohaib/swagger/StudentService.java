package com.zohaib.swagger;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    boolean createStudent(Student student);
    boolean updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);

}
