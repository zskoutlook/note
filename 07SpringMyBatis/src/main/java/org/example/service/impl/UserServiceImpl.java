package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.Account;
import org.example.pojo.User;
import org.example.service.AccountService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AccountService accountService;      //项目的所有事务必须添加到业务逻辑层上



    @Override
    public int insert(User user) {
        int num = userMapper.insert(user);
        System.out.println("用户增成功"+num);

    /*    调用账户的增加操作
        int i = accountService.save(new Account(209, "李四209", "账户安全209"));
        在User的事务种有Account的事务*/

        return num;
    }
}
