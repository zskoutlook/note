package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller         //交给spring创建对象
@RequestMapping("/two")         //类似于包名，可以把路径中相同的写这里
public class DemoAction2 {
    /*
           action中所有的功能实现都是由方法完成的
           规范：public、任意返回值、参数：可以有无，类型任意
                使用@RequestMapping注解声明一个访问的路径
       */
    @RequestMapping("/demo.action")
    public String demo(){
        System.out.println("进入控制器2");
        return "main";      //直接跳到    /one/admin/main.jsp
    }
}
