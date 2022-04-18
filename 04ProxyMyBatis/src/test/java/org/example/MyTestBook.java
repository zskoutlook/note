package org.example;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Book;
import org.example.domain.Users;
import org.example.mapper.BookMapper;
import org.example.mapper.UsersMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyTestBook {
        SqlSession sqlSession;
        BookMapper bookMapper;



        @Before
        public void openSqlSession() throws IOException {
            //1.使用文件流读取核心配置文件SqlMapConfig.xml            org.apache.ibatis.io.Resources
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            //3.取出sqlSession对象
            sqlSession = factory.openSession();
            //4.取出动态代理的对象(相当于之前的dao对象)，完成接口中方法的调用，实则是调用mapper.xml中相应的标签的功能
            bookMapper = sqlSession.getMapper(BookMapper.class);   //参数：接口对象
        }
        @After
        public void  closeSqlSession(){
            //7.关闭sqlSession对象
            sqlSession.close();
        }
    @Test
     public void testGetAllOne(){
        //5.调用接口的方法      返回所有书
        List<Book> list = bookMapper.getAllOne();
        list.forEach(book -> System.out.println(book));
    }
    @Test
    public void testGetAllTwo(){
        //5.调用接口的方法      返回所有书
        List<Book> list = bookMapper.getAllTwo();
        list.forEach(book -> System.out.println(book));
    }

}
