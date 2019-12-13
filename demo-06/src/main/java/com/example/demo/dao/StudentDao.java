package com.example.demo.dao;

import com.example.demo.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/11/5.
 */
@Repository
public interface StudentDao {
    public Student getStudentByid(int id);

    List<Student> getStuentList();
}
