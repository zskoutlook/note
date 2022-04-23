package org.example;


import org.example.threeTierArchitectureDemoTwo.controller.UsersController;
import org.example.threeTierArchitectureDemoTwo.dao.UsersMapper;
import org.example.threeTierArchitectureDemoTwo.pojo.Users;
import org.example.threeTierArchitectureDemoTwo.service.UsersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testThreeTwo {

    @Test
    public void testThreeInsertTwo(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersController usersController = (UsersController) ac.getBean("usersController");
        int i = usersController.insert(new Users(2, "赵六", 16));
        System.out.println(i);



        UsersService usersService = (UsersService) ac.getBean("usersServiceImpl");
        usersService.insert(new Users(2, "赵七", 16));
        UsersMapper usersMapper = (UsersMapper) ac.getBean("usersMapperImpl");
        usersMapper.insert(new Users(2, "赵八", 16));
    }
}
