package org.proxy4;

/*代理目标类，实现接口*/
public class BookServiceImpl implements Service {
    //父类中只有干净的业务
    public void buy(){
        System.out.println("图书购买业务功能实现……");
    }
}
