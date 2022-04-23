package org.example.vlaue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("roomValue")
public class Room {
    @Value("101")
    private int id;

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                '}';
    }
}
