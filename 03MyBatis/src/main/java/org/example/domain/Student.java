package org.example.domain;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    //无参构造
    public Student() {
    }
    //不包含主键参数的构造：因为添加操作时主键不用给值，会自增
    public Student(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    //全参构造
    public Student(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
