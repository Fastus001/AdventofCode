package com.karczmarzyk.advent2020.day13;

import java.nio.file.Files;

public class PartOne {
    public static void main(String[] args) {
        TimeStamp stamp = new TimeStamp(939);
        stamp.addBus(7);
        stamp.addBus(13);
        stamp.addBus(59);
        stamp.addBus(31);
        stamp.addBus(19);
    }
}
