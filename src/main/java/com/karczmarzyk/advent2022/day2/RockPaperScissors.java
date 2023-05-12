package com.karczmarzyk.advent2022.day2;

import lombok.Data;

import java.util.List;

@Data
public class RockPaperScissors {

    private List<String> inputLines;

    public RockPaperScissors(List<String> inputLines) {
        this.inputLines = inputLines;
    }

    public int getTotalScore(){
        return  inputLines.stream()
                .mapToInt(this::getScoreFromLinePartOne)
                .sum();
    }
    /*
     * A - rock -1
     * B - paper -2
     * C - scissor -3
     * X - rock
     * Y - paper
     * Z - scissor
     * */

    private int getScoreFromLinePartOne(String line) {
        return switch (line) {
            case "A X" -> 4;
            case "A Y" -> 8;
            case "A Z" -> 3;
            case "B X" -> 1;
            case "B Y" -> 5;
            case "B Z" -> 9;
            case "C X" -> 7;
            case "C Y" -> 2;
            case "C Z" -> 6;
            default -> throw new IllegalArgumentException();
        };
    }

    /*
     * A - rock -1
     * B - paper -2
     * C - scissor -3
     * X - need to lose
     * Y - draw
     * Z - win
     * */

    public int getTotalScorePartTwo(){
        return  inputLines.stream()
                .mapToInt(this::getScoreFromLinePartTwo)
                .sum();
    }

    private int getScoreFromLinePartTwo(String line) {
        return switch (line) {
            case "A X" -> 3;
            case "A Y" -> 4;
            case "A Z" -> 8;
            case "B X" -> 1;
            case "B Y" -> 5;
            case "B Z" -> 9;
            case "C X" -> 2;
            case "C Y" -> 6;
            case "C Z" -> 7;
            default -> throw new IllegalArgumentException();
        };
    }
}
