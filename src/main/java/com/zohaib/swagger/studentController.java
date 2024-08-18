package com.zohaib.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@Data
public class studentController {
    private StudentService studentService;
    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        boolean isStudentCreated = studentService.createStudent(student);
        if(isStudentCreated){
          return new ResponseEntity<>("Student created successfully", HttpStatus.CREATED);
        }else{
         return  new ResponseEntity<>("Student creation failed", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        boolean isStudentUpdated= studentService.updateStudent(id,student);
        if(isStudentUpdated){
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Student update failed", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean isStudentDeleted = studentService.deleteStudent(id);
        if(isStudentDeleted){
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Student deletion failed", HttpStatus.NOT_FOUND);
        }
    }

}
