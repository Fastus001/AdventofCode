package com.karczmarzyk.advent2015.day14;

public class Reindeer {
    private final String name;
    private final int speed;
    private final int flyTime;
    private final int restTime;

    public Reindeer(String name, int speed, int flyTime, int restTime)
    {
        this.name = name;
        this.speed = speed;
        this.flyTime = flyTime;
        this.restTime = restTime;
    }

    public int getDistance(int timeReindeerTravel) {
        if(timeReindeerTravel <= flyTime)
            return speed*timeReindeerTravel;
        int flyT = 0;
        while(timeReindeerTravel > 0)
        {
            if(timeReindeerTravel >= flyTime)
            {
                flyT += flyTime;
                timeReindeerTravel -=flyTime;
            }else
            {
                flyT += timeReindeerTravel;
                timeReindeerTravel = 0;
            }
            timeReindeerTravel -=restTime;
        }
        return flyT*speed;
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", flyTime=" + flyTime +
                ", restTime=" + restTime +
                '}';
    }
}
