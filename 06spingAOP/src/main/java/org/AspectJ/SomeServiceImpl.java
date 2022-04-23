package org.AspectJ;


import java.util.Date;

/*业务功能实现类*/
public class SomeServiceImpl implements SomeService{
    @Override
    public String dosome(String name, int age) {
        System.out.println("dosome业务功能实现");
        return "aaaa";
    }

    @Override
    public Date show() {
        System.out.println("show业务功能实现");
        return new Date();
    }

    @Override
    public String play(String name) {
        System.out.println("play业务功能实现");
        return name;
    }

    @Override
    public String sing() {
        System.out.println(1/0);        //算数异常
        return "两只老虎";
    }
}
