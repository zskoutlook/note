package org.example.mapper;

import org.example.domain.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getAllOne();    //实体类成员变量与列名不一致：使用别名

    List<Book> getAllTwo();    //实体类成员变量与列名不一致：使用手动映射
}
