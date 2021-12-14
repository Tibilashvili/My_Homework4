package com.example.homework4.service;


import com.example.homework4.entity.StudentGroup;
import com.example.homework4.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


@Service
public class StudentGroupService {
    @Autowired
    StudentGroupRepository studentGroupRepository;

    public List<StudentGroup> getAll() {
        List<StudentGroup> groupList = new ArrayList<>();
        studentGroupRepository.findAll().forEach(groupList::add);
        return groupList;
    }


    public boolean update(StudentGroup studentGroup, Long id) {
        if (studentGroupRepository.existsById(id)){
            studentGroup.setId(id);
            studentGroupRepository.save(studentGroup);
            return true;
        }
        return false;
    }

    public boolean create(StudentGroup studentGroup) {
        if (studentGroupRepository.save(studentGroup) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Long Id) {
        if (studentGroupRepository.findById(Id) != null) {
            studentGroupRepository.deleteById(Id);
            return true;
        } else {
            return false;
        }
    }
}
