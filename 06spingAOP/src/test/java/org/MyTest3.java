package org;

import org.junit.Test;
import org.proxy3.Agent;
import org.proxy3.BookServiceImpl;
import org.proxy3.ProductServiceImpl;
import org.proxy3.Service;
import sun.management.resources.agent;

public class MyTest3 {
    @Test
    public void test(){
        Service service1 = new Agent( new BookServiceImpl());
        service1.buy();
        //通过构造函数切换目标对象
        Service service2 = new Agent( new ProductServiceImpl());
        service2.buy();
    }
}
