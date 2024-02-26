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
        def list = Files.readAllLines( Path.of( 'src/main/java/com/karczmarzyk/advent2023/day1/input.txt' ) );

        when:
        def result = Trebuchet.getSum(list)

        then:
        result == 55172
    }

}