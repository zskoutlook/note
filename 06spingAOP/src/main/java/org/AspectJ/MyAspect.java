package org.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/*切面类，包含切面方法*/

@Aspect         //交给AspectJ框架去识别切面类
public class MyAspect {
    /*所有切面功能都是由切面方法来实现的*/


    //前置通知：value指定切入点表达式----->public、void、可选参数JoinPoint类型
    @Before(value = "execution(public * org.AspectJ.*.*(..))" )
    public void myBefore(JoinPoint joinPoint){
        System.out.println("切面方法的前置功能实现开始");
        System.out.println("目标方法的签名是"+joinPoint.getSignature());
        System.out.println("代理对象方法传入的参数是"+ Arrays.toString(joinPoint.getArgs()) );                 //getArgs()获取参数参数直接是一个数组
        System.out.println("切面方法的前置功能实现结束");
    }


    //后置通知：value指定切入点表达式----->public、void、可选参数一般为Object类型，是目标方法的返回值(所以可以改变目标方法的返回值:若是简单类型则不能改变，其他则可以改变)
    //returning：指定目标方法返回值名称，需要与切面方法参数一致
    @AfterReturning(value = "execution(public * org.AspectJ.*.show(..)))",returning="obj")
    public void myAfterReturning(Object obj){
        System.out.println("切面方法的后置功能实现开始");
        System.out.println(obj);
        ((Date) obj).setTime(0);            //修改目标方法返回值
        System.out.println("切面方法的后置功能实现结束");
    }


    //环绕通知：value指定切入点表达式----->public、类型、参数ProceedingJoinPoint类型
    @Around(value = "execution(public * org.AspectJ.*.play(..)))")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕中的前置");
        Object[] args = proceedingJoinPoint.getArgs();                  //获取传入的参数
        Object obj = proceedingJoinPoint.proceed(args);         //调用目标方法，传入参数
        System.out.println("环绕中的后置");
        return "足球";        //随便自己返
    }


    //最终通知：value指定切入点表达式----->public、void、可选参数JoinPoint类型
    @After(value = "name()")
    public void myAfter(){
        System.out.println("最终通知");
    }


    //定义切入点别名
    @Pointcut(value = "execution(public * org.AspectJ.*.*(..)))")
    public void name(){}

}
