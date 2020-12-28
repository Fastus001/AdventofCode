package com.karczmarzyk.advent2020.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("src/main/resources/2020/day18/day18input.txt"));

        long l = strings.stream()
                .mapToLong(Operator::getParentheses)
                .reduce(Long::sum)
                .orElse(-1);
        System.out.println("result = " + l);
    }
}
