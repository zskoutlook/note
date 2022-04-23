package org.example.threeTierArchitectureDemo.dao;

import org.example.threeTierArchitectureDemo.pojo.Users;

public class UsersMapperImpl implements UsersMapper{
    @Override
    public int insert(Users u) {
        System.out.println(u.getUname()+"增加成功");
        return 1;
    }
}
