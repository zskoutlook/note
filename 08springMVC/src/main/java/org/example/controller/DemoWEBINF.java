package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoWEBINF {
    @RequestMapping("/showIndex.action")
    public String showIndex(){
        System.out.println("访问WEB-INF的index页面");
        return "forward:/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping("/showMain.action")
    public String showMain(){
        System.out.println("访问WEB-INF的main页面");
        return "forward:/WEB-INF/jsp/main.jsp";
    }

    @RequestMapping("/showIndex")
    public String showIndex1(){
        System.out.println("访问WEB-INF的index页面,无.action");
        return "forward:/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping("/showMain")
    public String showMain1(){
        System.out.println("访问WEB-INF的main页面,无.action");
        return "forward:/WEB-INF/jsp/main.jsp";
    }




    @RequestMapping("/showLogin")
    public String showLogin(){
        System.out.println("访问WEB-INF的login页面,无.action");
        return "forward:/WEB-INF/jsp/login.jsp";
    }
    @RequestMapping("/login")
    public String Login(String name, String pwd, HttpServletRequest request){
        if("张三".equals(name)&&"123".equals(pwd)){
            request.getSession().setAttribute("user",name);          //存用户，配合拦截器
            return "forward:/WEB-INF/jsp/main.jsp";
        }else {
            request.setAttribute("msg","用户名或密码不正确");
            return "forward:/WEB-INF/jsp/login.jsp";
        }

    }

}
