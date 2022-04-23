package org;

import org.AspectJ.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MytestAspectJ {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");      //取出代理对象
        System.out.println(someService.getClass());

        String str = someService.dosome("张三", 18);
        System.out.println(str);
    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");      //取出代理对象
        Date show = someService.show();
        System.out.println(show);
    }

    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");      //取出代理对象
        String play = someService.play("篮球");

        System.out.println(play);
    }

    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");      //取出代理对象
        String sing = someService.sing();
        System.out.println(sing);
    }
}
