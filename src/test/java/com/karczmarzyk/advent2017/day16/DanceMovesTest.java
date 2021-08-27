package com.karczmarzyk.advent2017.day16;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class DanceMovesTest {

    @Test
    void spinMoveThree() {
        DanceMoves db = new DanceMoves("abcde");

        db.spin(3);

        assertThat(db.toString()).isEqualTo("cdeab");
    }

    @Test
    void exchangePositions() {
        DanceMoves db = new DanceMoves("eabcd");

        db.exchange(3,4);

        assertThat(db.toString()).isEqualTo("eabdc");
    }

    @Test
    void partnerSwap() {
        DanceMoves db = new DanceMoves("eabdc");

        db.partner('e', 'b');

        assertThat(db.toString()).isEqualTo("baedc");
    }

    @Test
    void checkDanceOrderAfterTestCaseDance(){
        List<Move> moves = List.of("s1", "x3/4", "pe/b").stream()
                .map(Move::new)
                .collect(Collectors.toList());
        DanceMoves dm = new DanceMoves("abcde");
        dm.setMoves(moves);

        dm.dance();

        assertThat(dm.toString()).isEqualTo("baedc");
    }

    @Test
    void checkFirstSolution() throws IOException {
        DanceMoves dm = new DanceMoves("abcdefghijklmnop");
        List<Move> moveList =
                Arrays.stream(Files.readString(Path.of("src/main/resources/2017/day16/input.txt"))
                        .split(","))
                        .map(Move::new)
                        .collect(Collectors.toList());
        dm.setMoves(moveList);

        dm.dance();

        assertThat(dm.toString()).isEqualTo("lbdiomkhgcjanefp");
    }

    @Test
    void checkSecondSolution() throws IOException {
        DanceMoves dm = new DanceMoves("abcdefghijklmnop");
        List<Move> moveList =
                Arrays.stream(Files.readString(Path.of("src/main/resources/2017/day16/input.txt"))
                        .split(","))
                        .map(Move::new)
                        .collect(Collectors.toList());
        dm.setMoves(moveList);

//        for (int i = 1; i <= 1_000_000_000; i++) {
        for (int i = 1; i <= 48; i++) {
            if(i % 10_000 ==0) {
                System.out.println("i = " + i);
            }
            dm.dance();
            if(dm.toString().equals("abcdefghijklmnop")){
                System.out.println("i taki sam string!= " + i);
            }
        }

        assertThat(dm.toString()).isEqualTo("ejkflpgnamhdcboi");
        //cykl się powtarza co 56 przejść!!
    }


}
