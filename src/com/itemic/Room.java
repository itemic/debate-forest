package com.itemic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Room {

    private int roomNumber;
    public List<Integer> teams;
    public Room round1Win;
    public Room round1Lose;
    public Room round2Win;
    public Room round2Lose;

    public Room(int roomNumber){
        this.roomNumber = roomNumber;
        this.teams = new ArrayList<>();
    }

    public String toString() {
        if (isBye()) {
            return "Sit Out";
        }

        return "Room " + roomNumber;
    }

    public boolean isBye() {
        return roomNumber == 0;
    }
}
