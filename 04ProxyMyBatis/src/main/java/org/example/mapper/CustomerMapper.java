package org.example.mapper;

import org.example.domain.Customer;

import java.util.List;

public interface CustomerMapper {
    Customer getById(Integer id);   //根据客户id查询所以订单   1对多

    Customer getById2(Integer id);   //根据客户id查询所以订单   1对多   分开sql

    Customer getById3(Integer id);   //根据客户id查询所以订单   1对多   分开sql(优化)
}
