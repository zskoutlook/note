package org.example.service.impl;

import org.example.mapper.AccountMapper;
import org.example.pojo.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//注解事务：
@Transactional(propagation = Propagation.REQUIRED,noRollbackForClassName = {"ArithmeticException"},noRollbackFor = {ArithmeticException.class},rollbackForClassName = {"NullPointerException"},rollbackFor = {NullPointerException.class},timeout = -1,readOnly = false,isolation = Isolation.DEFAULT)
//事务注解,事务传播特性-->异常时撤销    noRollbackForClassName:发生什么异常名为xxx时不撤销操作回滚    noRollbackFor:发生什么类型异常时不撤销操作
//
//                                  rollbackForClassName:发生异常名为xxx时必须回滚               rollbackFor:发生什么类型异常时必须回滚         isolation：数据库的隔离级别，使用数据库自己的隔离级别
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;



    @Override
    public int save(Account account) {
        int num = 0;
        num = accountMapper.save(account);
        System.out.println("账户增加成功"+num);
        System.out.println(1/0);        //手工抛出异常
        return num;
    }
}
