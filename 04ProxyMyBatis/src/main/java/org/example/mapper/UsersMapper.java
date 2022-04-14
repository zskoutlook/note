package org.example.mapper;

import org.example.domain.Users;

import java.util.List;

/*数据访问层的接口，该接口规定了数据库中的增删改查操作*/
public interface UsersMapper {
    List<Users> getAll();   //查询所有用户信息

    Users getById(Integer id);    //查询用户根据主键id

    List<Users> getByName(String userName); //根据名字的字模糊查询

    int insert(Users users);      //添加用户

    int update(Users users);      //更新用户

    int delete(Integer id);         //删除用户

}
