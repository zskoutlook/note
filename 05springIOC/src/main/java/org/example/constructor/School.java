package org.example.constructor;

public class School {
    private String name;
    private String address;

    public School(String name, String address) {
        System.out.println("有参构造器");
        this.name = name;
        this.address = address;
    }




    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
