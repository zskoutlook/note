package org.example.controller;

import org.example.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DemoDefaultParameters {
    /*转发跳转页面传数据*/
    @RequestMapping("/five1.action")
    public String five1(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, Map map, ModelMap modelMap){
        Student student1 = new Student("宗1", 1);
        request.setAttribute("student1",student1);                           //HttpServletRequest传递数据

        Student student2 = new Student("宗2", 2);
        session.setAttribute("student2",student2);                           //HttpSession传递数据

        Student student3 = new Student("宗3", 3);
        model.addAttribute("student3",student3);         //Model传递数据

        Student student4 = new Student("宗4", 4);
        map.put("student4",student4);                                              //Map传递数据

        Student student5 = new Student("宗5", 5);
        modelMap.addAttribute("student5",student5);     //ModelMap传递数据

        return "main";
    }

    /*重定向跳转页面传数据:因为重定向是从B端发的新请求，所以只有session能成功传递*/
    @RequestMapping("/five2.action")
    public String five2(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, Map map, ModelMap modelMap){
        Student student1 = new Student("宗1", 1);
        request.setAttribute("student1",student1);                           //HttpServletRequest传递数据

        Student student2 = new Student("宗2", 2);
        session.setAttribute("student2",student2);                           //HttpSession传递数据

        Student student3 = new Student("宗3", 3);
        model.addAttribute("student3",student3);         //Model传递数据

        Student student4 = new Student("宗4", 4);
        map.put("student4",student4);                                              //Map传递数据

        Student student5 = new Student("宗5", 5);
        modelMap.addAttribute("student5",student5);     //ModelMap传递数据

        return "redirect:/admin/main.jsp";
    }
}
