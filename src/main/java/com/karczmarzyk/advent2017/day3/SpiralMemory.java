package com.karczmarzyk.advent2017.day3;

import lombok.Data;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class SpiralMemory {
    private Direction direction = Direction.RIGHT;
    private int counterStart = 1;
    private int counter = 1;
    private int x = 0;
    private int y = 0;
    private List<Value> values = new ArrayList<>();

    public int steps(int dataSquare){
        values.add(new Value(0,0,1));
        for (int i = 2; i <= dataSquare; i++) {
            this.move();
        }
        return Math.abs(x)+Math.abs(y);
    }

    public int findFirstValueAbove(int target){
        values.add(new Value(0,0,1));
        while (true){
            this.move();
            int lastIndex = values.size() - 1;
            int value = values.get(lastIndex).getValue();
            if(value >target){
                return value;
            }
        }
    }

    private void move(){
        switch (direction){
            case RIGHT: moveRight(); break;
            case UP: moveUp(); break;
            case LEFT: moveLeft(); break;
            case DOWN: moveDown(); break;
            default:
                System.out.println("default!!");
        }
    }

    private void moveRight(){
        counter--;
        x++;
        values.add(new Value(x, y, this.getSumOfAdjacentValues(x,y)));
        if(counter == 0){
            this.direction = Direction.UP;
            counter = counterStart;
        }
    }

    private void moveUp(){
        counter--;
        y++;
        values.add(new Value(x, y, this.getSumOfAdjacentValues(x,y)));
        if(counter == 0) {
            direction = Direction.LEFT;
            counterStart++;
            counter = counterStart;
        }
    }

    private void moveLeft(){
        counter--;
        x--;
        values.add(new Value(x, y, this.getSumOfAdjacentValues(x,y)));
        if(counter == 0) {
            direction = Direction.DOWN;
            counter = counterStart;
        }
    }

    private void moveDown(){
        counter--;
        y--;
        values.add(new Value(x, y, this.getSumOfAdjacentValues(x,y)));
        if(counter == 0) {
            direction = Direction.RIGHT;
            counterStart++;
            counter = counterStart;
        }
    }

    private int getSumOfAdjacentValues(int x, int y){
          return values.stream().filter(value -> value.getX() >= x - 1 && value.getX() <= x + 1)
                  .filter(value -> value.getY() >= y - 1 && value.getY() <= y + 1)
                  .mapToInt(Value::getValue)
                  .sum();
    }

    @Data
    private class Value {
        int x;
        int y;
        int value;

        public Value(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

}
