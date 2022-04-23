package org.example.vlaue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("schoolValue")                  //交给spring创建对象，容器启动时创建              //注解里的内容是对象名，没给对象命名则默认的名字就是：小驼峰的类目
public class School {
    @Value("山东大学")
    private String name;
    @Value("山东")
    private String address;

    public School() {
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
