package org;

import org.junit.Test;
import org.proxy5.*;
import sun.management.resources.agent;

public class MyTest5 {
    @Test
    public void test(){
        Service agent1 = (Service) ProxyFactory.getAgent(new BookServiceImpl(), new TransactionAop());
        agent1.buy();
        String str = agent1.show(55);
        System.out.println(str);

        Service agent2 = (Service) ProxyFactory.getAgent(new ProductServiceImpl(), new LogAop());
        agent2.buy();


    }
    @Test
    public void test1(){
        Service agent = (Service) ProxyFactory.getAgent(new BookServiceImpl(), new TransactionAop());
        //多个切面对象
        Service agent1 = (Service) ProxyFactory.getAgent(agent, new LogAop());
        agent1.buy();
    }
}
