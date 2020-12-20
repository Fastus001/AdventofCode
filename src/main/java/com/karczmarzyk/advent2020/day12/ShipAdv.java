package com.karczmarzyk.advent2020.day12;

public class ShipAdv {
    private final Waypoint waypoint = new Waypoint();
    private long east = 0;
    private long west = 0;
    private long south = 0;
    private long north = 0;

    public void move(String dir, int value) {
        switch (dir) {
            case "N":
                waypoint.changeWaypoint("N",value);
                break;
            case "S":
                waypoint.changeWaypoint("S",value);
                break;
            case "E":
                waypoint.changeWaypoint("E",value);
                break;
            case "W":
                waypoint.changeWaypoint("W",value);
                break;
            case "L":
                waypoint.rotate(value,false);
                break;
            case "R":
                waypoint.rotate(value,true);
                break;
            case "F":
                moveForward(value);
                break;
            default:
                System.out.println("default");
        }
    }

    public void moveForward(int value) {
        east += (long) value * waypoint.getEast();
        west += (long) value * waypoint.getWest();
        north += (long) value * waypoint.getNorth();
        south += (long) value * waypoint.getSouth();
    }

    public long getShipLocation() {
        return Math.abs(Math.abs(east-west) + Math.abs(south-north));
    }

    public long getEastWestDistance() {
        return Math.abs(east-west);
    }

    public long getSouthNorthDistance() {
        return Math.abs(south-north);
    }
}
