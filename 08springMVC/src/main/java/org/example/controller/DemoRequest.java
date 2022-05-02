package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoRequest {
    /*请求转发页面*/
    @RequestMapping("/fore1.action")
    public String fore1(){
        System.out.println("请求转发页面");
        return "main";              //默认是请求转发，使用视图解析器拼接前缀后缀进行页面跳转
    }

    /*请求转发action*/
    @RequestMapping("/fore2.action")
    public String fore2(){
        System.out.println("请求转发action");
        return "forward:/other.action";              //默认是请求转发，forward:关键字表示这是转发，不会拼接前缀后缀。跳到另一个action
    }
    /*重定向页面*/
    @RequestMapping("/fore3.action")
    public String fore3(){
        System.out.println("重定向页面");
        return "redirect:/admin/main.jsp";                     //      redirect:关键字，表示重定向，不会拼接前缀后缀,需要自己手动拼接
    }

    /*重定向action*/
    @RequestMapping("/fore4.action")
    public String fore4(){
        System.out.println("重定向action");
        return "redirect:/other.action";                     //      redirect:关键字，表示重定向，不会拼接前缀后缀,需要自己手动拼接
    }




    @RequestMapping("other.action")
    public String fore2Other(){
        System.out.println("请求转发action到Other的页面");
        return "main";  //默认是请求转发，跳到另一个action
    }



}
