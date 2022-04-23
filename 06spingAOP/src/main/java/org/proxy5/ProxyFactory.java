package org.proxy5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getAgent(Service target,Aop aop){
        return Proxy.newProxyInstance(/*类加载器*/target.getClass().getClassLoader(),
                /*目标对象实现的所以接口*/target.getClass().getInterfaces(),
                /*代理功能实现*/new InvocationHandler() {
                    @Override
                    public Object invoke(/*生成的代理对象*/Object proxy,/*正在被调用的目标方法*/ Method method, /*目标方法的参数*/Object[] args) throws Throwable {
                        Object obj = null;
                        try {
                            aop.before();    //切面功能
                            obj = method.invoke(target, args);  //业务功能
                            aop.after();    //切面功能
                        }catch (Exception e){
                            aop.exception();    //切面功能
                        }
                        return obj; //目标方法返回值
                    }
                }); //返回动态代理对象
    }
}
