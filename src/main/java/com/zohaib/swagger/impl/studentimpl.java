package com.zohaib.swagger.impl;

import com.zohaib.swagger.Student;
import com.zohaib.swagger.StudentRepository;
import com.zohaib.swagger.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class studentimpl implements StudentService {

  private StudentRepository repository;

    public studentimpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean createStudent(Student student) {
        try{
            repository.save(student);
            return true;
        }catch(Exception e){
            return  false;
        }
    }

    @Override
    public boolean updateStudent(Long id, Student student) {
        Student student1 = repository.findById(id).orElse(null);
        if(student1!=null){
            student1.setName(student.getName());
            student1.setAge(student.getAge());
            repository.save(student1);
            return  true;
        }else{
            return  false;

        }
    }

    @Override
    public boolean deleteStudent(Long id) {
        Student s1 = repository.findById(id).orElse(null);
        if (s1!=null){
            repository.deleteById(s1.getId());
            return true;
        }else{
            return  false;
        }
    }
}
