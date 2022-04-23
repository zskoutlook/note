package org.example.threeTierArchitectureDemo.service.impl;

import org.example.threeTierArchitectureDemo.dao.UsersMapper;
import org.example.threeTierArchitectureDemo.dao.UsersMapperImpl;
import org.example.threeTierArchitectureDemo.pojo.Users;
import org.example.threeTierArchitectureDemo.service.UsersService;

public class UsersServiceImpl implements UsersService {
    private UsersMapper usersMapper;  // = new UsersMapperImpl()
    @Override
    public int insert(Users u) {
        return usersMapper.insert(u);
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }
}
