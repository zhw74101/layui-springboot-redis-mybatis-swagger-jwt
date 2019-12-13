package com.example.demo.controller;

import com.example.demo.annotations.UserLoginToken;
import com.example.demo.po.StudentPo;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentServiceImpl;
import com.example.demo.vo.BaseResoult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhanghongwei on 2019/11/4.
 */
//@Api 这个注解的tags属性不允许出现中文，否则该类对应的接口将不能使用点击打开的方式，而只能通过集体关闭和打开的方式使用
@Api(value = "这是一个测试类",description = "包含多个测试方法")
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private StudentServiceImpl studentService;


    @ApiOperation(value = "获取一个学生测试",notes = "不需要参数")
    @GetMapping("/getStudent")
    public Student test01(){
        Student student = new Student();
        student.setName("lily");
        return student;
    }

    @ApiOperation(value = "根据编号获取一个学生，参数通过问号传值，测试",notes = "需要学生编号")
    @GetMapping("getstudent")
    public Student getStudentById(StudentPo studentPo){
        Student student = studentService.getStudentById(studentPo.getId());
        return student;
    }

    @ApiOperation(value = "根据编号获取一个学生，参数通过路径传值，测试",notes = "需要学生编号")
    @ApiParam(name = "id",value = "学生编号",required = true)
    @GetMapping("getstudent/{id}")
    public Student getStudentByIdInUrlPath(@PathVariable("id") int id){
        Student student = studentService.getStudentById(id);
        return student;
    }


    @UserLoginToken
    @GetMapping("getStudentList")
    @ApiOperation(value = "获取学生列表",notes = "不需要参数，获取json数据")
    public BaseResoult<Student> getStudentList(){
        List<Student> list = studentService.getStuentList();
        BaseResoult<Student> baseResoult = new BaseResoult<>();
        baseResoult.setCode(0);
        baseResoult.setCount(list.size());
        baseResoult.setMsg("");
        baseResoult.setData(list);
        return baseResoult;
    }
}
