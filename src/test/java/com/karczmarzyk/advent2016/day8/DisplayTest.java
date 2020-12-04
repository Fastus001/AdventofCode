package com.karczmarzyk.advent2016.day8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    Display display;

    @BeforeEach
    void setUp() {
        display = new Display();
    }

    @Test
    void showDisplay() {
        display.showDisplay();
    }

    @Test
    void rect() {
        display.rect( 3,2 );
        display.showDisplay();
    }


    @Test
    void rotateRow() {
        display.rect( 3,2 );
        display.rotateRow( 0,49 );
        showDisplay();
    }

    @Test
    void rotateColumn() {
        display.rect( 3,2 );
        display.rotateColumn( 1,1 );
        display.rotateRow( 0,4 );
        display.rotateColumn( 1,1 );
        showDisplay();
    }
}