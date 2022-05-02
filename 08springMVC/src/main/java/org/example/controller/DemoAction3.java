package org.example.controller;

import org.example.Man;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.management.Agent;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoAction3 {
    @RequestMapping(value = "/three1.action",method = RequestMethod.GET)
    //请求参数名与形参名一致，就能在方法里获取参数,类型会自动根据形参类型转换
    public String threeGet1(String name,int age){
        System.out.println("处理get请求");
        System.out.println("name:"+name+"age:"+(age+1));
        return "main";
    }
    @RequestMapping(value = "/three1.action",method = RequestMethod.POST)
    public String threePost1(String name,int age){
        System.out.println("处理post请求");
        System.out.println("name:"+name+"age:"+(age+1));
        return "main";
    }

    @RequestMapping(value = "/three2.action",method = RequestMethod.GET)
    //请求参数名与实体类的成员变量名一致，类型会自动根据形参类型转换
    public String threeGet2(Man man){
        System.out.println("处理get请求");
        System.out.println(man);
        return "main";
    }
    @RequestMapping(value = "/three2.action",method = RequestMethod.POST)
    public String threePost2(Man man){
        System.out.println("处理post请求");
        System.out.println(man);
        return "main";
    }


    @RequestMapping(value = "/three3/{value1}/{value2}.action",method = RequestMethod.GET)
    //在路径中使用动态占位符提交数据，在控制器路径中接受数据，配合@PathVariable形参注解传入方法中
    public String threeGet3(@PathVariable("value1") String name, @PathVariable("value2") int age){
        System.out.println("处理get请求");
        System.out.println("name:"+name+"age:"+(age+1));
        return "main";
    }


    @RequestMapping(value = "/three4.action",method = RequestMethod.GET)
    //请求参数名与形参名不一致时，配合@RequestParam注解
    public String threeGet4(@RequestParam("name") String uname,@RequestParam("age") int uage){
        System.out.println("处理get请求");
        System.out.println("name:"+uname+"age:"+(uage+1));
        return "main";
    }
    @RequestMapping(value = "/three4.action",method = RequestMethod.POST)
    public String threePost4(@RequestParam("name") String uname,@RequestParam("age") int uage){
        System.out.println("处理post请求");
        System.out.println("name:"+uname+"age:"+(uage+1));
        return "main";
    }


    @RequestMapping(value = "/three5.action",method = RequestMethod.GET)
    //手工提取数据 形参是HttpServletRequest、
    public String threeGet5(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age")) ;
        System.out.println("处理get请求");
        System.out.println("name:"+name+"age:"+(age+1));
        return "main";
    }
    @RequestMapping(value = "/three5.action",method = RequestMethod.POST)
    public String threePost5(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age")) ;
        System.out.println("处理post请求");
        System.out.println("name:"+name+"age:"+(age+1));
        return "main";
    }

}


