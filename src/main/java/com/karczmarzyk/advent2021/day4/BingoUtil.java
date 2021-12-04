package com.karczmarzyk.advent2021.day4;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class BingoUtil {
    private List<Square> squares = new ArrayList<>();
    private int [] numbers;

    public BingoUtil(List<String> input) {
        parseInput(input);
    }

    public int getBingoResult() {
        int result =0;
        for (int number : numbers) {
            markNumber(number);
            Optional<Square> bingo = bingo();
            if (bingo.isPresent()) {
                result = bingo.get().getSumOfUnmarked()*number;
                break;
            }
        }
        return result;
    }

    public int getBingoLastResult() {
        int result =0;
        for (int number : numbers) {
            markNumber(number);
            Optional<Square> bingo = bingo();
            if (bingo.isPresent()) {
                if(squares.size()>1){
                    this.squares = squares.stream().filter(square -> !square.isRowOrColFull()).collect(Collectors.toList());
                } else {
                    result = bingo.get().getSumOfUnmarked()*number;
                    break;
                }
            }
        }
        return result;
    }

    private void parseInput(List<String> input) {
        this.numbers = getNumbers(input.get(0),",");
        for (int i = 1; i < input.size(); i+=6) {
            List<Pair> pairs = new ArrayList<>();
            for (int j = 1; j < 6; j++) {
                String[] s = input.get(i + j).trim().split(" ");
                for (String value : s) {
                    pairs.add(new Pair(Integer.parseInt(value.trim()), false));
                }
            }
            squares.add(new Square(pairs));
        }
    }

    public void markNumber(int number) {
        squares.stream().flatMap(square -> square.getNumbers().stream())
                .filter(pair -> pair.getNumber() == number)
                .forEach(pair -> pair.setChecked(true));
    }

    public Optional<Square> bingo() {
        return squares.stream()
                .filter(Square::isRowOrColFull)
                .findFirst();
    }

    public static int[] getNumbers(String line, String regex) {
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(Arrays.toString(numbers)).append("\n");
        squares.forEach(square -> sb.append(square.toString()).append("\n"));
        return sb.toString();
    }
}
