package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.pojo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 */
@Service
public class StudentServiceImpl implements  StudentService {

    @Resource
    private StudentDao studentDao;
    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentByid(id);
    }



    @Override
    public List<Student> getStuentList() {
        return studentDao.getStuentList();
    }
}
