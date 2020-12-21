package com.karczmarzyk.advent2020.day13;

import java.util.List;

public class TimeStampAdv {
    private final List<Bus> buses;
    private long stamp;
    private final long increment;
    private final long maxOffset;

    public TimeStampAdv(String input) {
        this.buses = Input.getListOfBuses(input);
        increment = 18937;
        maxOffset = 29;
        this.stamp = 18937;
    }

    public long findFirstTimeStamp(){
        while(true){
            if(testValue(stamp)){
                return stamp-maxOffset;
            }
            stamp+=increment;
            if(stamp % 823000000 == 0 )
                System.out.println(stamp);
        }
    }

    private boolean testValue(long stamp) {
        for (Bus bus : buses) {
            long test = stamp + (bus.getOffset()-maxOffset);
            if ((test % bus.getId()) != 0) {
                return false;
            }
        }
        return true;
    }
}
