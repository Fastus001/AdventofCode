package com.karczmarzyk.advent2021.day2;

import java.util.List;
import java.util.function.Consumer;

public class Dive {
    private static int horizontal = 0;
    private static int depth = 0;
    private static int aim = 0;

    public static int computeDistance(List<String> plannedCourse, Consumer<Course> move) {
        horizontal =0;
        depth =0;
        aim =0;
        plannedCourse.stream()
                .map(p->{
                    String[] split = p.split(" ");
                    return new Course(split[0], Integer.parseInt(split[1]));
                }).forEach(move);

        return horizontal*depth;
    }

    public static Consumer<Course> move() {
        return course -> {
            switch (course.direction()){
                case "forward" -> horizontal+=course.distance();
                case "down" -> depth+=course.distance();
                case "up" -> depth-=course.distance();
            }
        };
    }

    public static Consumer<Course> move2() {
        return course -> {
            switch (course.direction()){
                case "forward" -> {
                    horizontal += course.distance();
                    depth += aim * course.distance();
                }
                case "down" -> aim+=course.distance();
                case "up" -> aim-=course.distance();
            }};
    }
}

record Course(String direction, int distance) {}
