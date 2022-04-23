package org.proxy5;

/*
代理类，实现接口。*/
public class Agent implements Service {
    private Service target;             //静态代理已经实现了目标对象的灵活切换
    private Aop aop;            //静态代理已经实现了切面对象的灵活切换


    public Agent(Service target, Aop aop) {
        this.target = target;
        this.aop = aop;
    }

    public Agent(Service target) {      //使用构造对象传入目标对象
        this.target = target;
    }


    @Override
    public void buy() {
        try {
            aop.before();           //切面功能
            target.buy();
            aop.after();           //切面功能
        }catch (Exception e){
            aop.exception();           //切面功能
        }

    }
}
