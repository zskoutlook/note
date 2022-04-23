package org.example;

import org.example.setter.School;
import org.example.setter.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTestSetter {
    @Test
    public void testStudent(){               //传统方式
        Student student = new Student();
        System.out.println(student);
    }
    @Test
    public void testStudentSpring(){        //spring方式
        //创建容器对象并启动(启动容器则会自动创建出bean对象)
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");   //resources下的路径，因为编译后会被放入calsses文件夹下
        //注意：创建的对象都是Object类型
        org.example.setter.Student studentSetter = (org.example.setter.Student) ac.getBean("studentSetter");                        //基于XML   setter注入
        org.example.constructor.Student studentConstructor = (org.example.constructor.Student) ac.getBean("studentConstructor");     //基于XML  构造器注入
        org.example.vlaue.Student studentValue = (org.example.vlaue.Student) ac.getBean("studentValue");            //基于注解的对象创建，school属性是自动注入、Room使用b按名称注入
        System.out.println(studentSetter);
        System.out.println(studentConstructor);
        System.out.println(studentValue);
    }
    @Test
    public void testSchoolSpring(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        org.example.setter.School schoolSetter = (org.example.setter.School) ac.getBean("schoolSetter");                        //基于XML   setter注入
        org.example.constructor.School schoolConstructor = (org.example.constructor.School) ac.getBean("schoolConstructor");    //基于XML  构造器注入
        org.example.vlaue.School schoolValue = (org.example.vlaue.School) ac.getBean("schoolValue");                            //基于注解
        System.out.println(schoolSetter);
        System.out.println(schoolConstructor);
        System.out.println(schoolValue);

    }
    @Test
    public void testRoomSpring(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        org.example.setter.Room roomSetter = (org.example.setter.Room) ac.getBean("roomSetter");                        //基于XML   setter注入
        org.example.constructor.Room roomConstructor = (org.example.constructor.Room) ac.getBean("roomConstructor");    //基于XML  构造器注入
        org.example.vlaue.Room roomValue = (org.example.vlaue.Room) ac.getBean("roomValue");                            //基于注解
        System.out.println(roomSetter);
        System.out.println(roomConstructor);
        System.out.println(roomValue);

    }



}
