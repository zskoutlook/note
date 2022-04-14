package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Users;
import org.example.mapper.UsersMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyTest {
    SqlSession sqlSession;
    UsersMapper usersMapper;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");     //日期格式刷子




    @Before
    public void openSqlSession() throws IOException {
        //1.使用文件流读取核心配置文件SqlMapConfig.xml            org.apache.ibatis.io.Resources
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.取出sqlSession对象
        sqlSession = factory.openSession();
        //4.取出动态代理的对象(相当于之前的dao对象)，完成接口中方法的调用，实则是调用mapper.xml中相应的标签的功能
        usersMapper = sqlSession.getMapper(UsersMapper.class);   //参数：接口对象
    }
    @After
    public void  closeSqlSession(){
        //7.关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testGetAll(){
        //5.调用接口的方法      返回所有用户
        List<Users> list = usersMapper.getAll();
        list.forEach(users -> System.out.println(users));


        //System.out.println(usersMapper.getClass());
    }
    @Test
    public void testGetById(){
        //5.调用接口的方法   根据id查找用户
        Users users = usersMapper.getById(2);
        System.out.println(users);
    }

    @Test
    public void testGetByName(){
        //5.调用接口的方法           根据名字模糊查询
        List<Users> list = usersMapper.getByName("张");
        list.forEach(users ->System.out.println(users) );

    }
    @Test
    public void testInsert(){
        //5.调用接口的方法       添加数据
        int insert = usersMapper.insert(new Users("宗绍凯", new Date(), "1", "青岛"));
        //6.增删改 要关闭
        sqlSession.commit();
        System.out.println(insert);

    }

    @Test
    public void testUpdate() throws ParseException {
        //5.调用接口的方法          更新数据                                                 使用日期格式刷子返回一个Date对象
        int update = usersMapper.update(new Users(1, "王丽", simpleDateFormat.parse("1997-11-10"), "2", "美国"));
        //6.增删改 要关闭
        sqlSession.commit();
        System.out.println(update);

    }

    @Test
    public void testDelete(){
        //5.调用接口的方法          根据id删除用户
        int delete = usersMapper.delete(5);
        //6.增删改 要关闭
        sqlSession.commit();
        System.out.println(delete);

    }


}
