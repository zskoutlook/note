package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    private SqlSession sqlSession;


    @Before//该注解会在所有@Test方法执行前先执行一次
    public void openSqlSession()throws IOException{
        //1.使用文件流读取核心配置文件SqlMapConfig.xml            org.apache.ibatis.io.Resources
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.取出sqlSession对象
        sqlSession = factory.openSession();     //openSession()：传参数false默认是手工提交事务、true是自动提交
    }
    @After//该注解会在所有@Test方法执行后再执行一次
    public void  closeSqlSession(){
        //6.关闭sqlSession对象
        sqlSession.close();
    }


    @Test
    public void testGetAll()  {
        //4.完成查询所有人的操作       mapper的id.语句的id
        List<Student> list = sqlSession.selectList("zsk.getAll");

        list.forEach(student -> System.out.println(student));
    }
    @Test
    public void testGetById()  {
        //4.完成查询某个id的操作       mapper的id.语句的id
        Student student = sqlSession.selectOne("zsk.getById",1);

        System.out.println(student);
    }
    @Test
    public void testGetByName()  {
        //4.完成模糊查询操作       mapper的id.语句的id
        List<Student> listName = sqlSession.selectList("zsk.getByName", "张");

        listName.forEach(student -> System.out.println(student));
    }
    @Test
    public void testInsert()  {
        //4.完成插入操作       mapper的id.语句的id
        int insert = sqlSession.insert("zsk.insert", new Student("王大麻子123", "11700@111.com", 155));
        //5.增删改 操作完要提交事务
        sqlSession.commit();

        System.out.println(insert);
    }
    @Test
    public void testDelete()  {
        //4.完成删除操作       mapper的id.语句的id
        int delete = sqlSession.delete("zsk.delete", 6);
        //5.增删改 操作完要提交事务
        sqlSession.commit();

        System.out.println(delete);
    }
    @Test
    public void testUpdate()  {
        //4.完成更新操作       mapper的id.语句的id
        int update = sqlSession.update("zsk.update", new Student(1, "张三6三", "30000@qq.com", 3000));
        //5.增删改 操作完要提交事务
        sqlSession.commit();

        System.out.println(update);
    }


}
