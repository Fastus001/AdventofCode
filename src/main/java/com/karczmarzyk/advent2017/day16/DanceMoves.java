package com.karczmarzyk.advent2017.day16;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

@Data
public class DanceMoves {
    private static int CHAR_LENGTH;
    private char [] chars;
    private List<Move> moves;
    private char [] temp;

    public DanceMoves(String input) {
        this.chars = input.toCharArray();
        CHAR_LENGTH = this.chars.length;
    }

    public void spin(int move) {
        char [] temp = new char[CHAR_LENGTH];
        for (int i = 0; i < CHAR_LENGTH; i++, move++) {
            if(move == CHAR_LENGTH) {
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
        for (int i = 0; i < CHAR_LENGTH; i++) {
            if(chars[i] == first){
                firstIndex = i;
            }
            if(chars[i] == second) {
                secondIndex = i;
            }
            if(firstIndex > -1 && secondIndex > -1) break;
        }
        exchange(firstIndex,secondIndex);
    }

    public void dance() {
        moves.forEach(getMove());
    }

    @NotNull
    private Consumer<Move> getMove() {
        return move -> {
            switch (move.getName()) {
                case "s":
                    spin(move.getValueA());
                    break;
                case "x":
                    exchange(move.getValueA(), move.getValueB());
                    break;
                case "p":
                    partner(move.getProgramA(), move.getProgramB());
                    break;
                default:
            }
        };
    }

    @Override
    public String toString() {
        var sb =  new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
