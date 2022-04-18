package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Users;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*数据访问层的接口，该接口规定了数据库中的增删改查操作*/
public interface UsersMapper {
    List<Users> getAll();   //查询所有用户信息

    Users getById(Integer id);    //查询用户根据主键id

    List<Users> getByName(String userName); //根据名字的字模糊查询

    int insert(Users users);      //添加用户

    int update(Users users);      //更新用户

    int delete(Integer id);         //删除用户

    List<Users> getByNameOrAddress(     //模糊用户名或地址查询  配合注解
            @Param("columnName")
            String columnName,
            @Param("columnValue")
            String columnValue);


    List<Users> getAllDynamicSQL();   //动态sql查询所有用户信息

    List<Users> getDynamicSQL(Users users);     //动态sql查询某些所有用户信息

    int updateDynamicSQL(Users users);      //动态sql更新用户

    List<Users> getByIds(Integer[] arr);    //动态sql查询用户根据多个主键id

    List<Users> getByBirthday(Date begin,Date ebd);   //查询某些用户信息（多个参数）

    List<Users> getByBirthdayByMap(Map map);   //查询某些用户信息（参数1个map）

    Map getReturnMap(Integer id);   //查询某些用户信息,返回值是1个map

    List<Map> getReturnMaps();   //查询某些用户信息,返回值是多个个map，使用一个List<map>装在一起

}
