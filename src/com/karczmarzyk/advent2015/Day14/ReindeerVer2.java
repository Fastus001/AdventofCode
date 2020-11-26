package com.karczmarzyk.advent2015.Day14;

import java.util.ArrayList;

public class ReindeerVer2 {
    private final String name;
    private final int speed;
    private final int flyTime;
    private final int restTime;
    public final ArrayList<Integer> distanceEachSecond = new ArrayList<>();
    private int score;

    ReindeerVer2(String name, int speed, int flyTime, int restTime)
    {
        this.name = name;
        this.speed = speed;
        this.flyTime = flyTime;
        this.restTime = restTime;
        this.score =0;
    }

    public void addOneScore()
    {
        score++;
    }

    public int getScore(){
        return score;
    }

    public void addDistance(int seconds)
    {
        int sum = 0;
        int fl = 1;
        int rst = 1;
        while(seconds > 0)
        {
            if(fl <= flyTime){
                sum +=speed;
                distanceEachSecond.add(sum);
                fl++;
            }else{
                distanceEachSecond.add(sum);
                rst++;
                if(rst > restTime)
                {
                    fl =1;
                    rst = 1;
                }
            }
            seconds--;
        }
    }

    public int getDistance() {
        return distanceEachSecond.get(distanceEachSecond.size()-1);
    }

    public void showArray()
    {
        System.out.println("Nazwa" + name + ": distanceEachSecond = " + distanceEachSecond);
    }

    @Override
    public String toString() {
        return "ReindeerVer2{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", flyTime=" + flyTime +
                ", restTime=" + restTime +
                ", score=" + score +
                '}';
    }
}
