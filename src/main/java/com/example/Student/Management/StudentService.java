package com.example.Student.Management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "Rahul", "rahul@example.com", "B.Tech Civil"));
        students.add(new Student(2, "Aditi", "aditi@example.com", "BCA"));
        students.add(new Student(3, "Sameer", "sameer@example.com", "BSc CS"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // updated: existing student update, nahi mila to add
    public Student updateStudent(int id, Student updated) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updated.getName());
                s.setEmail(updated.getEmail());
                s.setCourse(updated.getCourse());
                return s;
            }
        }
        // agar given id nahi mili, list me new entry add kar de
        students.add(updated);
        return updated;
    }

    // delete student by id
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
