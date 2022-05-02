package org.example;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MyDate {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public MyDate() {
    }

    public MyDate(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
