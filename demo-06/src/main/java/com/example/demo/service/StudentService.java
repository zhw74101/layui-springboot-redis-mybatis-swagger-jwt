package com.example.demo.service;

import com.example.demo.pojo.Student;

import java.util.List;

/**
 */
public interface StudentService {
    public Student getStudentById(int id);

    List<Student> getStuentList();
}
