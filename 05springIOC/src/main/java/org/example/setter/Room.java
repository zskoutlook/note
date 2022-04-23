package org.example.setter;

public class Room {
    private int id;

    public Room() {
        System.out.println("Room的无参构造");
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                '}';
    }
}
