package org.example.constructor;

public class Room {
    private int id;

    public Room(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                '}';
    }


}
