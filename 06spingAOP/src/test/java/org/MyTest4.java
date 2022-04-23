package org;

import org.junit.Test;
import org.proxy4.*;

public class MyTest4 {
    @Test
    public void test(){
        Service service1 = new Agent(new BookServiceImpl(), new TransactionAop());
        service1.buy();

        Service service2 = new Agent(new ProductServiceImpl(), new LogAop());
        service2.buy();
    }
    @Test
    public void testAgent(){
        Service agent = new Agent(new BookServiceImpl(), new TransactionAop());
        Agent agent1 = new Agent(agent, new LogAop());//让代理对象被代理，传入要增加的切面对象
        agent1.buy();
    }
}
