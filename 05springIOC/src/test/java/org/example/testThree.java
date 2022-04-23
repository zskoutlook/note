package org.example;


import org.example.threeTierArchitectureDemo.controller.UsersController;
import org.example.threeTierArchitectureDemo.pojo.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testThree {
    @Test
    public void testThreeInsert(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersController usersController = (UsersController) ac.getBean("uController");
        int i = usersController.insert(new Users(1, "王五", 14));
        System.out.println(i);

    }
}
