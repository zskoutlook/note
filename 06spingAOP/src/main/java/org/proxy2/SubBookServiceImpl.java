package org.proxy2;
/*子类：代理类，代理父类，将父类的图书购买功能添加到业务切面*/
public class SubBookServiceImpl extends BookServiceImpl{
    public void buy(){
        try {
            //事务切面
            System.out.println("事务开启……");
            //主业务实现
            super.buy();
            //事务切面
            System.out.println("事务提交……");
        }catch (Exception e){
            //事务切面
            System.out.println("事务回滚……");
        }
    }
}
