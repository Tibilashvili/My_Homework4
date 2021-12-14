package com.example.homework4.controller;


import com.example.homework4.entity.StudentGroup;
import com.example.homework4.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/groups")
public class StudentGroupController {

    @Autowired
    StudentGroupService studentGroupService;


    @GetMapping(path = "/get/students")
    public List<StudentGroup> getStudentGroup() {
        return studentGroupService.getAll();
    }


    @PostMapping(path = "/post/addstudentgroup")
    public String addStudentGroup(@RequestBody StudentGroup studentGroup) {
        if (studentGroupService.create(studentGroup)) {
            return studentGroup.getId() + "added successfully";
        } else {
            return studentGroup.getId() + "failed to add";
        }
    }

    @DeleteMapping(path = "/deleteuser/{id}")
    public String deleteGroupStudent(@PathVariable("id") Long Id) {
        if (studentGroupService.delete(Id)) {
            return Id + "deleted successfully";
        } else {
            return Id + "failed to delete";
        }
    }
}
