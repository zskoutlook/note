package org.proxy1;
/*图书购买业务和事务切面耦合在一起*/
public class BookServiceImpl {
    public void buy(){
        try {
            System.out.println("事务开启……");
            System.out.println("图书购买业务功能实现……");
            System.out.println("事务提交……");
        }catch (Exception e){
            System.out.println("事务回滚……");
        }

    }
}
