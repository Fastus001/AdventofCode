package com.karczmarzyk.advent2020.day12;

public class Ship {
    private int direction = 0;
    private int eastWest = 0;
    private int southNorth = 0;

    public void changeDirection(String d, int degrees){
        if (d.equals("R")){
            direction+=degrees;
        }else{
            direction-=degrees;
        }
        direction = direction % 360;
    }

    public void move(String dir, int value){
        switch (dir){
            case "N":southNorth-=value;break;
            case "S":
                southNorth +=value;break;
            case "E":
                eastWest +=value;break;
            case "W":eastWest-=value;break;
            case "L":changeDirection("L",value);break;
            case "R":changeDirection("R",value);break;
            case "F":moveForward(value);break;
            default:
                System.out.println("default");
        }
    }

    public void moveForward(int value){
        switch (direction){
            case 0: eastWest +=value;break;
            case 90:case -270:southNorth +=value;break;
            case 180:case -180:eastWest-=value;break;
            case 270:case -90:southNorth-=value;break;
        }
    }

    public int getShipLocation(){
        return Math.abs(eastWest+southNorth);
    }

    public int getDirection() {
        return direction;
    }

    public int getEastWest() {
        return eastWest;
    }

    public int getSouthNorth() {
        return southNorth;
    }
}
