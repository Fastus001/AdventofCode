package com.karczmarzyk.advent2016.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

class GridTest {
    private Grid grid;
    @BeforeTest
    public void setup()
    {
        grid = new Grid();
    }

    @Test
    public void testGrid()
    {
        grid.getCoordinates( "R2" );
        assertEquals( "East",grid.getDirectionName() );
    }

    @Test
    public void testGridCaseOne()
    {
        grid.getCoordinates( "R2" );
        grid.getCoordinates( "L3" );

        assertEquals( 5,grid.getDistance() );
    }

    @Test
    public void testGridCaseTwo()
    {
        grid.getCoordinates( "R2" );
        grid.getCoordinates( "R2" );
        grid.getCoordinates( "R2" );

        assertEquals( 2,grid.getDistance() );
    }

    @Test
    public void testGridCaseThree()
    {
        grid.getCoordinates( "R5" );
        grid.getCoordinates( "L5" );
        grid.getCoordinates( "R5" );
        grid.getCoordinates( "R3" );

        assertEquals( 12,grid.getDistance() );
    }

    @Test
    public void testDirectionChanges()
    {
        grid.getCoordinates( "L2" );
        grid.getCoordinates( "L2" );
        grid.getCoordinates( "L2" );
        grid.getCoordinates( "L2" );
        grid.getCoordinates( "L2" );
    }




}
