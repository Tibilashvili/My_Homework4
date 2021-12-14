package com.example.homework4.service;

import com.example.homework4.entity.Student;
import com.example.homework4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        List<Student> studentsList = new ArrayList<>();
        studentRepository.findAll().forEach(studentsList::add);
        return studentsList;
    }

    public Student getStudentById(Long Id) {
        Optional<Student> optionalStudent = studentRepository.findById(Id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }



    public boolean update(Student student, Long id) {
        if (studentRepository.existsById(id)){
            student.setId(id);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    public boolean create(Student student) {
        if (studentRepository.save(student) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Student getStudentGroupById(Long Id) {
        Optional<Student> optionalStudentGroup = studentRepository.findById(Id);
        if (optionalStudentGroup.isPresent()) {
            return optionalStudentGroup.get();
        } else {
            return null;
        }
    }

    public boolean delete(Long Id) {
        if (studentRepository.findById(Id) != null) {
            studentRepository.deleteById(Id);
            return true;
        } else {
            return false;
        }
    }
}
