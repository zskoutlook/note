package org.example;

import static org.junit.Assert.assertTrue;

import org.example.pojo.Account;
import org.example.pojo.User;
import org.example.service.AccountService;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest {

    @Test
    public void testUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        UserService uService = (UserService) ac.getBean("userServiceImpl");
        int i = uService.insert(new User(100, "张三", "123"));
        System.out.println(i);

    }

    @Test
    public void testAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        AccountService aService = (AccountService) ac.getBean("accountServiceImpl");
        aService.save(new Account(119,"李四","账户安全"));


    }
    @Test
    public void testAccountEX(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        AccountService aService = (AccountService) ac.getBean("accountServiceImpl");
        aService.save(new Account( 122,"李四289","账户安全22388"));


    }

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_transactional.xml");
        AccountService aService = (AccountService) ac.getBean("accountServiceImpl");
        aService.save(new Account(130,"李四215","账户安全215"));


    }



}
