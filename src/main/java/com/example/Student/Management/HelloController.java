package com.example.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class HelloController {

    @Autowired
    private StudentService studentService;

    // GET /students -> sab students
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    // POST /students -> naya student add
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // PUT /students/{id} -> existing student update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updated) {
        return studentService.updateStudent(id, updated);
    }

    // DELETE /students/{id} -> student delete
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    // GET /students/hello -> simple test
    @GetMapping("/hello")
    public String helloStudent() {
        return "Student Management Backend is Running!";
    }
}
