package org.proxy5;

/*代理目标类，实现接口*/
public class BookServiceImpl implements Service {
    //父类中只有干净的业务
    public void buy(){
        System.out.println("图书购买业务功能实现……");
    }

    @Override
    public String show(int age) {
        System.out.println("show业务功能实现……");
        return "参数:"+age+":show方法被调用";
    }
}
