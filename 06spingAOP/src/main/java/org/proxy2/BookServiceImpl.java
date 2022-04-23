package org.proxy2;
/*图书购买业务和事务切面拆分*/
public class BookServiceImpl {
    //父类中只有干净的业务
    public void buy(){
        System.out.println("图书购买业务功能实现……");
    }
}
