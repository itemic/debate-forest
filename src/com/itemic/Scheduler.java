package com.itemic;

import java.util.*;

public class Scheduler {

    public final int POOL_MINIMUM = 8;
    private int size;
    public Scheduler(int size) {
        this.size = size;
    }

    public void pool() {
        int teamCount = this.size;
        int poolsOfEight = 0;
        int remainderPoolSize = 0;

        // figure out pool size
        if (teamCount < POOL_MINIMUM) {
            remainderPoolSize = teamCount;
        } else {
            while (teamCount > 15) {
                poolsOfEight++;
                teamCount -= 8;
            }
            remainderPoolSize = teamCount;
        }

        System.out.println(poolsOfEight + " pools of 8 teams and a pool with " + teamCount);


    }

    public void schedule() {
        // just handle exact pods for now

        int roomsNeeded = size / 2;
        int roomStartNumber = 1;
        int offset = (int)Math.ceil(size/8.0);


        System.out.println("Rooms needed: " + roomsNeeded);
        System.out.println("Room range: " + roomStartNumber + "-" + (roomsNeeded+roomStartNumber-1));
        System.out.println(offset);



        List<Room> roomList = new ArrayList<>();
        for (int i = roomStartNumber; i < roomStartNumber + roomsNeeded; i++) {
            roomList.add(new Room(i));
        }




//        Collections.shuffle(roomList);
        if (size % 2 != 0) {
            // add a BYE room
            Room bye = new Room(0);
            roomList.add(bye);
        }

        System.out.println(roomList);

        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
 // 2 3 2 4
            room.round1Win = roomList.get((i + offset) % roomList.size());
            room.round1Lose = roomList.get((i + offset+1) % Math.max(1, roomsNeeded));
            room.round2Win = roomList.get((i + offset) % roomList.size());
            room.round2Lose = roomList.get((i + offset + offset) % roomList.size());
        }



        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            teamList.add(new Team((i+101) + "", roomList.get(i/2)));
        }

        for (Team team: teamList) {
            System.out.println("-----------------------------");
            team.displayTree();
            System.out.println("");
        }







    }
}
