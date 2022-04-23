package org.example.threeTierArchitectureDemoTwo.controller;

import org.example.threeTierArchitectureDemoTwo.pojo.Users;
import org.example.threeTierArchitectureDemoTwo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {
    @Autowired
    public UsersService usersService;     // = new UsersServiceImpl()

    public int insert(Users u){
        int num = usersService.insert(u);
        return num;
    }


}
