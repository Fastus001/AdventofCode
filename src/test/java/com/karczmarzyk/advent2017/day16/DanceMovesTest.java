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
        DanceMoves dm = new DanceMoves("abcde");

        dm.dance(List.of("s1", "x3/4", "pe/b"));

        assertThat(dm.toString()).isEqualTo("baedc");
    }

    @Test
    void checkFirstSolution() throws IOException {
        DanceMoves dm = new DanceMoves("abcdefghijklmnop");
        List<String> moveList =
                Arrays.stream(Files.readString(Path.of("src/main/resources/2017/day16/input.txt"))
                        .split(","))
                        .collect(Collectors.toList());

        dm.dance(moveList);

        assertThat(dm.toString()).isEqualTo("lbdiomkhgcjanefp");
    }


}
