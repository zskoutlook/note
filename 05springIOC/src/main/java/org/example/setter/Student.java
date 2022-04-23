package org.example.setter;

public class Student {
    private String name;
    private int age;

    private School school;

    private Room room;



    public Student() {
        System.out.println("学生的无参构造");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                ", room=" + room +
                '}';
    }
}
