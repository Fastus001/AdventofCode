package com.karczmarzyk.advent2015.day13;

public class Guest {
    private final String name;
    private final String friend;
    private final int happines;


    public Guest(String name, String friend, Integer happiness)
    {
        this.name = name;
        this.friend = friend;
        this.happines = happiness;
    }

    public int getHappiness(){
        return this.happines;
    }

    public String getName() {
        return name;
    }

    public String getFriend() {
        return friend;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", friend='" + friend + '\'' +
                ", happines=" + happines +
                '}';
    }
}
