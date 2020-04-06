package com.itemic;

public class Team {
    private String name;
    public Room startingRoom;

    public Team(String name, Room startingRoom) {
        this.name = prettifyName(name);
        this.startingRoom = startingRoom;
    }

    private String prettifyName(String input) {
        if (input.length() >= 3) {
            return input;
        }

        String updated = "000" + input;
        return (updated.substring(updated.length()-3, updated.length()));

    }

    public void displayTree() {

        String startRoom = startingRoom == null ? "BYE" : startingRoom + "";


        System.out.println("TEAM " + this.name);
        System.out.println("                 " + startingRoom.round1Win.round2Win);
        System.out.println("                /");
        System.out.println("         " + startingRoom.round1Win);
        if (!startingRoom.round1Win.isBye()) {
            System.out.println("        /       \\");
            System.out.println("       /         " + startingRoom.round1Win.round2Lose);
        } else {
            System.out.println("        /       ");
            System.out.println("       /         ");
        }

        System.out.println(startingRoom);
        if (!startingRoom.isBye()) {
            System.out.println("       \\         " + startingRoom.round1Lose.round2Win);
            System.out.println("        \\       /");
            System.out.println("         " + startingRoom.round1Lose);
            if (!startingRoom.round1Lose.isBye()) {
                System.out.println("                \\");
                System.out.println("                 " + startingRoom.round1Lose.round2Lose);
            } else {
                System.out.println("                ");
                System.out.println("                 ");
            }

        } else {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }

    }
}
