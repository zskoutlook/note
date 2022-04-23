package org.example.threeTierArchitectureDemoTwo.service.impl;

import org.example.threeTierArchitectureDemoTwo.dao.UsersMapper;
import org.example.threeTierArchitectureDemoTwo.pojo.Users;
import org.example.threeTierArchitectureDemoTwo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;  // = new UsersMapperImpl()
    @Override
    public int insert(Users u) {
        return usersMapper.insert(u);
    }

}
