package com.example.homework4.repository;

import com.example.homework4.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {
}
