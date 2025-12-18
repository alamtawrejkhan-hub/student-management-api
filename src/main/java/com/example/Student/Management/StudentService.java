package com.example.Student.Management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public StudentService() {
        // initial dummy data
        students.add(new Student(nextId++, "Rahul", "rahul@example.com", "B.Tech Civil"));
        students.add(new Student(nextId++, "Aditi", "aditi@example.com", "BCA"));
        students.add(new Student(nextId++, "Sameer", "sameer@example.com", "BSc CS"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        if (student.getId() == 0) {
            student.setId(nextId++);
        }
        students.add(student);
        return student;
    }

    public Student updateStudent(int id, Student updated) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updated.getName());
                s.setEmail(updated.getEmail());
                s.setCourse(updated.getCourse());
                return s;
            }
        }
        // agar nahi mila to naya add kar de (optional)
        if (updated.getId() == 0) {
            updated.setId(nextId++);
        }
        students.add(updated);
        return updated;
    }

    public void deleteStudent(int id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == id) {
                it.remove();
                break;
            }
        }
    }
}
