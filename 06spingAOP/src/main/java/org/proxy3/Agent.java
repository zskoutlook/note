package org.proxy3;
/*
代理类，实现接口。*/
public class Agent implements Service{
    private Service target;             //静态代理已经实现了目标对象的灵活切换

    public Agent(Service target) {      //使用构造对象传入目标对象
        this.target = target;
    }


    @Override
    public void buy() {
        try {
            System.out.println("事务开启……");           //切面功能
            target.buy();
            System.out.println("事务提交……");           //切面功能
        }catch (Exception e){
            System.out.println("事务回滚……");           //切面功能
        }

    }
}
