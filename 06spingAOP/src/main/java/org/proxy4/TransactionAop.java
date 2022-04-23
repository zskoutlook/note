package org.proxy4;

public class TransactionAop implements Aop{
    @Override
    public void before() {
        System.out.println("事务开启……");           //切面功能
    }

    @Override
    public void after() {
        System.out.println("事务提交……");           //切面功能
    }

    @Override
    public void exception() {
        System.out.println("事务回滚……");           //切面功能
    }
}
