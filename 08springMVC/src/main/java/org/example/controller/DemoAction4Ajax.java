package org.example.controller;

import org.example.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoAction4Ajax {
    @RequestMapping("/list.action")
    @ResponseBody                        //用来解析ajax请求,且必须在springmvc。xml中添加注解驱动
    public List<Student> list(){
        List<Student> list = new ArrayList<>();

        Student student1 = new Student("张三",12);
        Student student2 = new Student("李四",13);
        Student student3 = new Student("王五",14);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        System.out.println("进入get方法");
        return list;        //spring框架会帮助将集合转为json数组
    }

}
