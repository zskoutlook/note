package org.proxy5;

public class LogAop implements Aop {
    @Override
    public void before() {
        System.out.println("前置日志输出………………");
    }
}
