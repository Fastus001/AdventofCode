package com.karczmarzyk.advent2020.day13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void getListOfBuses() {
        List<Bus> listOfBuses = Input.getListOfBuses("7,13,x,x,59,x,31,19");

        assertEquals(5,listOfBuses.size());
        assertEquals(55,listOfBuses.get(2).getIdByOffset());

    }
}