package org.example.vlaue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("studentValue")
public class Student {
    @Value("李四")
    private String name;
    @Value("80")
    private int age;


    @Autowired
    private School school;          //引用类型按类型注入：会自动去Bean工厂中找同源类型的对象

    @Autowired
    @Qualifier("roomValue")         //去工厂找该名的对象
    private Room room;              //引用类型按名称注入：会自动去Bean工厂中找同源类型且对应名称（roomValue）的对象注入给该成员变量

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                ", roomValue=" + room +
                '}';
    }
}
