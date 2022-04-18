package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Customer;
import org.example.domain.Orders;
import org.example.mapper.CustomerMapper;
import org.example.mapper.OrdersMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTestCustomerOrders {
    SqlSession sqlSession;
    CustomerMapper customerMapper;
    OrdersMapper ordersMapper;



    @Before
    public void openSqlSession() throws IOException {
        //1.使用文件流读取核心配置文件SqlMapConfig.xml            org.apache.ibatis.io.Resources
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.取出sqlSession对象
        sqlSession = factory.openSession();
        //4.取出动态代理的对象(相当于之前的dao对象)，完成接口中方法的调用，实则是调用mapper.xml中相应的标签的功能
        customerMapper = sqlSession.getMapper(CustomerMapper.class);   //参数：接口对象
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);   //参数：接口对象
    }
    @After
    public void  closeSqlSession(){
        //7.关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testGetByIdCustomerMapper(){
        //5.调用接口的方法      返回Id的Customer对象  1对多，查1的信息，包含多的列表信息
        Customer customer1 = customerMapper.getById(1);
        System.out.println(customer1);

        Customer customer2 = customerMapper.getById(2);
        System.out.println(customer2);

        Customer customer3 = customerMapper.getById(3);
        System.out.println(customer3);
    }
    @Test
    public void testGetByIdCustomerMapper2(){
        //5.调用接口的方法      返回Id的Customer对象  1对多，查1的信息，包含多的列表信息    第二种方法：分开写
        Customer customer1 = customerMapper.getById2(1);
        System.out.println(customer1);

        Customer customer2 = customerMapper.getById2(2);
        System.out.println(customer2);

        Customer customer3 = customerMapper.getById2(3);
        System.out.println(customer3);
    }
    @Test
    public void testGetByIdCustomerMapper3(){
        //5.调用接口的方法      返回Id的Customer对象  1对多，查1的信息，包含多的列表信息    第二种方法：分开写（优化）
        Customer customer1 = customerMapper.getById3(1);
        System.out.println(customer1);

        Customer customer2 = customerMapper.getById3(2);
        System.out.println(customer2);

        Customer customer3 = customerMapper.getById3(3);
        System.out.println(customer3);
    }


    @Test
    public void testGetByIdOrdersMapper(){
        //5.调用接口的方法      返回Id的Customer对象  1对多，查1的信息，包含多的列表信息
        Orders orders = ordersMapper.getById(11);
        System.out.println(orders);

    }
}
