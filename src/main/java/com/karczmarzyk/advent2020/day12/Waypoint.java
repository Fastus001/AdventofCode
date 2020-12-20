package com.karczmarzyk.advent2020.day12;

public class Waypoint {
    private int north = 1;
    private int east = 10;
    private int south = 0;
    private int west = 0;


    public void changeWaypoint(String s, int value){
        switch (s) {
            case "N":
                north += value;
                break;
            case "S":
                south += value;
                break;
            case "E":
                east += value;
                break;
            case "W":
                west += value;
                break;
        }
    }

    public void rotate(int degrees, boolean right){
        for (int i = 0; i < degrees/90; i++) {
            if(right){
                rotateRightOnce();
            }else{
                rotateLeftOnce();
            }
        }
    }

    private void rotateRightOnce(){
        int temp = west;
        west = south;
        south = east;
        east = north;
        north = temp;
    }

    private void rotateLeftOnce(){
        int temp = north;
        north = east;
        east = south;
        south = west;
        west = temp;
    }

    public int getEast() {
        return east;
    }

    public int getNorth() {
        return north;
    }

    public int getWest() {
        return west;
    }

    public int getSouth() {
        return south;
    }
}
