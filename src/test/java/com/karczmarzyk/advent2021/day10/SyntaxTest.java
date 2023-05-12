package com.karczmarzyk.advent2021.day10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SyntaxTest {

    @Test
    void getIllegalCharacterTestCase() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("src/main/resources/2021/day10/test.txt"));

        Syntax syntax = new Syntax();
        Map<String, Long> collect = lines.stream().map(syntax::getIllegalCharacter)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long sum = collect.get(")")*3+collect.get("]")*57+collect.get("}")*1197+collect.get(">")*25137;

        Assertions.assertThat(sum).isEqualTo(26397);
    }

    @Test
    void getIllegalCharacterPartOne() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("src/main/resources/2021/day10/input.txt"));

        Syntax syntax = new Syntax();
        Map<String, Long> result = lines.stream().map(syntax::getIllegalCharacter)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long sum = result.get(")")*3+result.get("]")*57+result.get("}")*1197+result.get(">")*25137;

        Assertions.assertThat(sum).isEqualTo(389589L);
    }

    @Test
    void partTwoTestCase() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("src/main/resources/2021/day10/test.txt"));

        SyntaxUtil syntaxUtil = new SyntaxUtil();

        long result = syntaxUtil.setUncompletedSyntax(lines);

        Assertions.assertThat(result).isEqualTo(288957L);
    }

    @Test
    void partTwo() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("src/main/resources/2021/day10/input.txt"));

        SyntaxUtil syntaxUtil = new SyntaxUtil();

        long result = syntaxUtil.setUncompletedSyntax(lines);

        Assertions.assertThat(result).isEqualTo(1190420163L);
    }
}