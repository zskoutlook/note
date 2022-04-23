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
import java.util.*;

public class MyTestUsers {
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
        Users users = new Users("宗绍凯6", new Date(), "1", "青岛");
        System.out.println(users);
        //5.调用接口的方法       添加数据      并把主键值给参数id属性
        int insert = usersMapper.insert(users);
        //6.增删改 要关闭
        sqlSession.commit();
        System.out.println(insert);
        System.out.println(users);

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
    @Test
    public void testGetByNameOrAddress(){
        //5.调用接口的方法          模糊用户名或地址查询
        List<Users> users1 = usersMapper.getByNameOrAddress("username", "小");     //模糊查用户
        System.out.println(users1);

        List<Users> users2 = usersMapper.getByNameOrAddress("address", "美");
        System.out.println(users2);
    }

    @Test
    public void testUuid(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String str = uuid.toString().replace("-","");       //替换掉-变成32为数字、字母
        System.out.println(str);

    }






    @Test
    public void testGetAllDynamicSQL(){
        //5.调用接口的方法      动态sql引用sql片段返回所有用户
        List<Users> list = usersMapper.getAllDynamicSQL();
        list.forEach(users -> System.out.println(users));
    }
    @Test
    public void testGetDynamicSQL() throws ParseException {     //多条件动态sql查询
        Users users = new Users();
        users.setAddress("青岛");
        users.setUserName("宗1");
        users.setBirthday(simpleDateFormat.parse("2022-4-14"));
        users.setSex("1");
        //5.调用接口的方法      动态sql引用sql片段返回所有用户
        List<Users> list = usersMapper.getDynamicSQL(users);
        list.forEach(user -> System.out.println(user));
    }
    @Test
    public void testUpdateDynamicSQL() throws ParseException {
        Users users = new Users();
        users.setId(1);
        users.setUserName("王力");
        users.setSex("1");
        users.setAddress("天津");
        users.setBirthday(simpleDateFormat.parse("1997-11-10"));
        System.out.println(users);
        //5.调用接口的方法          更新数据                                                 使用日期格式刷子返回一个Date对象
        int update = usersMapper.updateDynamicSQL(users);
        //6.增删改 要关闭
        sqlSession.commit();
        System.out.println(update);
    }

    @Test
    public void testGetByIds(){
        //5.调用接口的方法   根据id查找用户
        Integer[] arr = {1,2,3};
        List<Users> list = usersMapper.getByIds(arr);
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetByBirthday() throws ParseException {
        //5.调用接口的方法      返回所有用户
        List<Users> list = usersMapper.getByBirthday(simpleDateFormat.parse("1997-11-10"),simpleDateFormat.parse("1999-9-22"));
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetByBirthdayByMap() throws ParseException {
        Map map = new HashMap<>();
        map.put("begin",simpleDateFormat.parse("1997-11-10"));
        map.put("end",simpleDateFormat.parse("1999-9-22"));
        //5.调用接口的方法      返回所有用户
        List<Users> list = usersMapper.getByBirthdayByMap(map);
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetReturnMap() throws ParseException {
        //5.调用接口的方法      返回所有用户
        Map map = usersMapper.getReturnMap(1);
        System.out.println(map);
    }

    @Test
    public void testGetReturnMaps() throws ParseException {
        //5.调用接口的方法      返回所有用户
        List<Map> list = usersMapper.getReturnMaps();
        list.forEach(map -> System.out.println(map));
    }
}
