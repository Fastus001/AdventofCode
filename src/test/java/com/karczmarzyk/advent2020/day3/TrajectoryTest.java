package com.karczmarzyk.advent2020.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrajectoryTest {

    @Test
    public void testTraverse()
    {
        Trajectory trajectory = new Trajectory();
        trajectory.getInput("src/main/resources/2020/day3sample.txt");
        trajectory.traverse();
        assertEquals( 7,trajectory.getCounter() );
    }

    @Test
    public void testTraverseTaskPartOne()
    {
        Trajectory trajectory = new Trajectory();
        trajectory.getInput("src/main/resources/2020/day3/day3.txt");
        trajectory.traverse();
        assertEquals( 176,trajectory.getCounter() );
    }

}