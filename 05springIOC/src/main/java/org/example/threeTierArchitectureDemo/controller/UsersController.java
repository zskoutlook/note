package org.example.threeTierArchitectureDemo.controller;

import org.example.threeTierArchitectureDemo.pojo.Users;
import org.example.threeTierArchitectureDemo.service.UsersService;
import org.example.threeTierArchitectureDemo.service.impl.UsersServiceImpl;

public class UsersController {
    public UsersService usersService;     // = new UsersServiceImpl()

    public int insert(Users u){
        int num = usersService.insert(u);
        return num;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
