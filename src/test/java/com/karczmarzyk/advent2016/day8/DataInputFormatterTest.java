package com.karczmarzyk.advent2016.day8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataInputFormatterTest {
    DataInputFormatter dif;

    @BeforeEach
    void setUp() {
        dif =  new DataInputFormatter( new Display() );
    }

    @Test
    void checkArray() {
        dif.getData( "src/main/resources/2016/day8/day8.txt" );
        assertEquals( 110,dif.checkArray() );
        dif.show();

    }

}