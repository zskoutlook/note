package org.proxy5;
/*静态代理接口*/
public interface Service {
     void buy();
     default String show(int age){ return null; };
}
