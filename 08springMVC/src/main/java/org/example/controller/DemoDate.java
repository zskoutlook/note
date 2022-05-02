package org.example.controller;

import org.example.MyDate;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DemoDate {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");     //日期格式刷子

    /*单个参数的注解*/
    @RequestMapping("/six1.action")
    public String six1(@DateTimeFormat(pattern = "yyyy-MM-dd") Date mydate, HttpServletRequest request) throws ParseException {            //该注解（单个）是将页面的String类型日期注入给Date类型参数
        System.out.println("使用的是单个日期注解");
        System.out.println(mydate);


        String dateStr = simpleDateFormat.format(mydate);                               //把Date类型日期使用格式化刷子做成String类型想要的格式
        System.out.println(dateStr);
        request.setAttribute("dateStr",dateStr);                                                         //1.单个日期类型对象：直接转成String格式，传到响应页。
        request.setAttribute("mydate",mydate);                                                           //2.直接传Date类型的数据



        MyDate myDate1 = new MyDate("今天", simpleDateFormat.parse("2000-01-12"));
        MyDate myDate2 = new MyDate("明天", simpleDateFormat.parse("1999-01-12"));
        List<MyDate> list = new ArrayList<>();
        list.add(myDate1);
        list.add(myDate2);
        request.setAttribute("list",list);                                                              //2.list中的实体类对象的成员变量是日期格式，必须使用JSTL


        return "main";
    }




    /*类中全局日期注解*/
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,true));
    }
    /*类中有了全局日期注解，就不需要在形参前加上特定注解了*/
    @RequestMapping("/six2.action")
    public String six2(Date mydate){                                    //不需要加注解，因为类中有全局的日期处理注解（全局）
        System.out.println("使用的是全局日期注解");
        System.out.println(mydate);

        String DateStr = simpleDateFormat.format(mydate);
        System.out.println(DateStr);
        return "main";
    }
}
