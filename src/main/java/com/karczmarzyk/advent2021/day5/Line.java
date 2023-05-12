package com.karczmarzyk.advent2021.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final Coordinate start;
    private final Coordinate end;

    public Line(String input) {
        String[] split = input.split(" -> ");
        String[] start = split[0].split(",");
        this.start = new Coordinate(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
        String[] end = split[1].split(",");
        this.end = new Coordinate(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
        if (!isDiagonal()) {
            if (this.start.getX() > this.end.getX()) {
                switchValuesX(this.start, this.end);
            }
            if (this.start.getY() > this.end.getY()) {
                switchValuesY(this.start, this.end);
            }
        }
    }

    public List<Coordinate> computeNonDiagonalCoordinates() {
        List<Coordinate> temp = new ArrayList<>();
        if(!isDiagonal()){
            temp.addAll(getHorizontal());
            temp.addAll(getVertical());
        }
        return temp.stream().distinct().collect(Collectors.toList());
    }

    public List<Coordinate> computeAll() {
        List<Coordinate> temp = new ArrayList<>(computeNonDiagonalCoordinates());
        if(isDiagonal()){
            temp.addAll(getDiagonal());
        }
        return temp.stream().distinct().collect(Collectors.toList());
    }

    private List<Coordinate> getDiagonal() {
        List<Coordinate> temp = new ArrayList<>();
        if (start.getX() < end.getX() && start.getY() < end.getY()) {
            for (int i = start.getX(), x = 0; i <= end.getX(); i++, x++) {
                temp.add(new Coordinate(start.getX() + x, start.getY() + x));
            }
        } else if (start.getX() < end.getX() && start.getY() > end.getY()) {
            int finish = start.getY() - end.getY();
            for (int i = 0, x = 0, y = 0; i <= finish; i++, x++, y--) {
                temp.add(new Coordinate(start.getX() + x, start.getY() + y));
            }
        } else if (start.getX() > end.getX() && start.getY() < end.getY()) {
            int finish = start.getX() - end.getX();
            for (int i = 0, x = 0, y = 0; i <= finish; i++, x--, y++) {
                temp.add(new Coordinate(start.getX() + x, start.getY() + y));
            }
        } else {
            int finish = start.getX() - end.getX();
            for (int i = 0, x = 0; i <= finish; i++, x--) {
                temp.add(new Coordinate(start.getX() + x, start.getY() + x));
            }
        }
        return temp;
    }

    private List<Coordinate> getHorizontal() {
        List<Coordinate> temp = new ArrayList<>();
        for (int i = start.getX(); i <= end.getX(); i++) {
            temp.add(new Coordinate(i, start.getY()));
        }
        return temp;
    }

    private List<Coordinate> getVertical() {
        List<Coordinate> temp = new ArrayList<>();
        for (int i = start.getY(); i <= end.getY(); i++) {
            temp.add(new Coordinate(start.getX(), i));
        }
        return temp;
    }

    private void switchValuesX(Coordinate first, Coordinate second) {
        int temp = first.getX();
        first.setX(second.getX());
        second.setX(temp);
    }

    private void switchValuesY(Coordinate first, Coordinate second) {
        int temp = first.getY();
        first.setY(second.getY());
        second.setY(temp);
    }

    private boolean isDiagonal() {
        return start.getX() != end.getX() && start.getY() != end.getY();
    }
}
