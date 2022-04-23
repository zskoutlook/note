package org.example.threeTierArchitectureDemoTwo.dao;

import org.example.threeTierArchitectureDemoTwo.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository           //创建数据访问层对象
public class UsersMapperImpl implements UsersMapper {
    @Override
    public int insert(Users u) {
        System.out.println(u.getUname()+"增加成功");
        return 1;
    }
}
