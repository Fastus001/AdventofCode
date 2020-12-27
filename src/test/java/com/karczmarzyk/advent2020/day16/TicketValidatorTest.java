package com.karczmarzyk.advent2020.day16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketValidatorTest {
    TicketValidator validator;
    InputDataValidator dataValidator;

    @BeforeEach
    void setUp() {
        validator = new TicketValidator();
        dataValidator = new InputDataValidator();
        List<Range> rangeList = new ArrayList<>();
        rangeList.add(new Range(1,3));
        rangeList.add(new Range(5,7));
        rangeList.add(new Range(6,11));
        rangeList.add(new Range(33,44));
        rangeList.add(new Range(13,40));
        rangeList.add(new Range(45,50));
        validator.setRoutes(rangeList);
    }

    @Test
    void getNotValidFields() {
        int [] temp = {38,6,12};
        assertEquals(12,validator.getNotValidFields(temp));
    }

    @Test
    void testPartOne() throws IOException {
        TicketValidator validator1 = new TicketValidator();

        validator1.setRoutes(dataValidator.getListOfRanges("src/main/resources/2020/day16/ticketFields.txt"));
        List<int[]> nearbyTickets = dataValidator.getNearbyTickets("src/main/resources/2020/day16/nearbyTickets.txt");

        int result = nearbyTickets.stream()
                .mapToInt(TicketValidator::getNotValidFields)
                .reduce(Integer::sum)
                .orElse(-1);

        assertEquals(26941,result);
    }

    @Test
    void checkDataColumnWithTheRanges() {
        TicketValidator validator1 = new TicketValidator();
        List<Range> rangeList = new ArrayList<>();
        rangeList.add(new Range(0,1));
        rangeList.add(new Range(4,19));
        rangeList.add(new Range(0,5));
        rangeList.add(new Range(8,19));
        rangeList.add(new Range(0,13));
        rangeList.add(new Range(16,19));
        validator1.setRoutes(rangeList);

        int[] tab = {3,15,5};
        int[] tab1 = {9,1,14};
        int[] tab2 = {18,5,9};
        assertEquals(1,validator1.checkDataColumnWithTheRanges(tab));
        assertEquals(2,validator1.checkDataColumnWithTheRanges(tab1));
        assertEquals(3,validator1.checkDataColumnWithTheRanges(tab2));

    }
}