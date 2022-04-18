package org.example.domain;

import java.util.List;

public class Book {
    private Integer id;
    private String name;

    private List<Object> list;


    public Book() {
    }

    public Book(Integer id, String name, List<Object> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
