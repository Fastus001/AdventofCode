package com.karczmarzyk.advent2020.day16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputDataValidatorTest {
    InputDataValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputDataValidator();
    }

    @Test
    void getListOfRanges() throws IOException {
        List<Range> listOfRanges = validator.getListOfRanges("src/main/resources/2020/day16/ticketFields.txt");

        assertAll(()->assertEquals(27,listOfRanges.get(0).getMin()),
                ()->assertEquals(374,listOfRanges.get(0).getMax()));
    }

    @Test
    void getNearbyTickets() throws IOException {
        List<int []> listOfRanges = validator.getNearbyTickets("src/main/resources/2020/day16/nearbyTickets.txt");

        assertAll(()->assertEquals(473,listOfRanges.get(0)[0]),
                ()->assertEquals(113,listOfRanges.get(0)[19]));
    }

    @Test
    void getColumn() throws IOException {
        List<int []> listOfRanges = validator.getNearbyTickets("src/main/resources/2020/day16/nearbyTickets.txt");
        int[] column = validator.getColumn(listOfRanges, 0);

        assertEquals(241,column.length);
        assertEquals(681,column[240]);
    }
}