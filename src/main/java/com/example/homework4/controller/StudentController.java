package com.example.homework4.controller;


import com.example.homework4.entity.Student;
import com.example.homework4.entity.StudentGroup;
import com.example.homework4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping(path = "/get/students")
    public List<Student> getUsers() {
        return studentService.getAll();
    }


    @GetMapping(path = "/get/{id}")
    public List<Student> getStudentsById(@PathVariable(name = "id") Long Id) {
        List<Student> studentGroupList = new ArrayList<>();
        studentGroupList.add(studentService.getStudentById(Id));
        return studentGroupList;
    }

    @PostMapping(path = "/post/addstudent")
    public String addStudent(@RequestBody Student student) {
        if (studentService.create(student)) {
            return student.getId() + "added successfully";
        } else {
            return student.getId() + "failed to add";
        }
    }

    @DeleteMapping(path = "/delete/deletestudent/{id}")
    public String deleteStudent(@PathVariable("id") Long Id) {
        if (studentService.delete(Id)) {
            return Id +  "deleted successfully";
        } else {
            return Id + "failed to delete";
        }
    }

}
