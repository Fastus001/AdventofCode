package com.karczmarzyk.advent2023.day1

import spock.lang.Specification

class TrebuchetSecondTest extends Specification {

    def'should properly convert string value'() {
        expect:
        def trebuchet = new TrebuchetSecond()
        result  == trebuchet.convert(input)

        where:
        input           |    result
        'two1nine'      |   '219'
        'eightwothree'  | '823'
        'abcone2threexyz' | 'abc123xyz'
    }
}
