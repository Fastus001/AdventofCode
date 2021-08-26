package com.karczmarzyk.advent2017.day16;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import static java.lang.Integer.parseInt;

public class DanceMoves {
    private char [] chars;

    public DanceMoves(String input) {
        this.chars = input.toCharArray();
    }

    @Override
    public String toString() {
        var sb =  new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void spin(int move) {
        char [] temp = new char[chars.length];
        for (int i = 0; i < chars.length; i++, move++) {
            if(move == chars.length) {
                move = 0;
            }
            temp[move] = chars[i];
        }
        chars = temp;
    }

    public void exchange(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public void partner(char first, char second) {
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == first){
                firstIndex = i;
            }
            if(chars[i] == second) {
                secondIndex = i;
            }
        }
        exchange(firstIndex,secondIndex);
    }

    public void dance(List<String> danceMoves) {
        danceMoves.forEach(getMove());
    }

    @NotNull
    private Consumer<String> getMove() {
        return move -> {
            switch (move.substring(0, 1)) {
                case "s":
                    String s1 = move.substring(1).trim();
                    spin(parseInt(s1));
                    break;
                case "x":
                    String[] split = move.substring(1).split("/");
                    exchange(parseInt(split[0]), parseInt(split[1]));
                    break;
                case "p":
                    partner(move.charAt(1), move.charAt(3));
                    break;
                default:
            }
        };
    }
}
