package com.karczmarzyk.advent2023.day1

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path

class TrebuchetTest extends Specification{

    def 'should get sum number'() {
        expect:
        result == Trebuchet.getNumber(input)

        where:
        input | result
        '1abc2' | '12'
        'a1b2c3d4e5f' | '15'
        'treb7uchet' | '77'
    }

    def 'should return sum 142'() {
        given:
        def list = ['1abc2', 'pqr3stu8vwx', 'a1b2c3d4e5f', 'treb7uchet']

        when:
        def result = Trebuchet.getSum(list)

        then:
        result == 142
    }

    def 'should return sum for first part'() {
        given:
        def list = Files.readAllLines( Path.of( 'src/main/java/com/karczmarzyk/advent2023/day1/input.txt' ) )

        when:
        def result = Trebuchet.getSum(list)

        then:
        result == 55172
    }

    def 'should return sum for second part test samples'() {
        given:
        def list = Files.readAllLines( Path.of( 'src/main/java/com/karczmarzyk/advent2023/day1/testInput.txt' ) )
        def converter = new TrebuchetSecond()

        when:
        def result = Trebuchet.getSum(list.stream().map { it -> converter.convert(it)} as List<String>)

        then:
        result == 281
    }

    def 'should return sum for second part'() {
        given:
        def list = Files.readAllLines( Path.of( 'src/main/java/com/karczmarzyk/advent2023/day1/input.txt' ) )
        def converter = new TrebuchetSecond()

        when:
        def result = Trebuchet.getSum(list.stream().map { it -> converter.convert(it)} as List<String>)

        then:
        result == 54925
    }

}