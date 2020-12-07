package com.karczmarzyk.advent2020.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Custom {

    public static long countCustomQuestions(String questions)
    {
        return Stream.of( questions.toCharArray() ).flatMap( Custom::streamOfChars)
                .distinct()
                .count();
    }

    public static Stream<Character> streamOfChars(char[] tab)
    {
        List<Character> lst = new ArrayList<>();
        for (char c : tab) {
            lst.add( c );
        }
        return lst.stream();
    }
}
