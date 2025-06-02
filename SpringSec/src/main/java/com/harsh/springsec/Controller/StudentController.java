package com.harsh.springsec.Controller;

import com.harsh.springsec.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"Harsh",89),
            new Student(2,"Navin",90)
    ));
    @GetMapping("/getstudents")
    public List<Student> getAllStudents(){
        return students;
    }
    @GetMapping("/getcsrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
