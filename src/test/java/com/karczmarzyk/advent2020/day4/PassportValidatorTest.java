package com.karczmarzyk.advent2020.day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportValidatorTest {

    @Test
    void validate() {

        assertTrue( PassportValidator.validate( "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm" ) );
        assertFalse( PassportValidator.validate( "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929" ) );
        assertTrue( PassportValidator.validate( "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm" ) );
        assertFalse( PassportValidator.validate( "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in" ) );
    }
}