package org.example.constructor;

public class Student {
    private String name;
    private int age;

    private School school;
    private Room roomConstructor;

    public Student(String name, int age, School school, Room roomConstructor) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.roomConstructor = roomConstructor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                ", roomConstructor=" + roomConstructor +
                '}';
    }
}
