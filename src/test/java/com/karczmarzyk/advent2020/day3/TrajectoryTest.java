package com.karczmarzyk.advent2020.day3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrajectoryTest {
    Trajectory trajectory;

    @BeforeEach
    public void setTrajectory()
    {
        trajectory = new Trajectory();
    }

    @Test
    public void testTraverse()
    {
        trajectory.getInput("src/main/resources/2020/day3/day3sample.txt");
        assertEquals( 7,trajectory.getTreeNumber( 3, 1) );
    }

    @Test
    public void testTraverseTaskPartOne()
    {
        trajectory.getInput("src/main/resources/2020/day3/day3.txt");
        assertEquals( 176,trajectory.getTreeNumber( 3, 1));
    }

    @Test
    public void testTraversePartTwo()
    {
        trajectory.getInput("src/main/resources/2020/day3/day3sample.txt");
        int sum = trajectory.getTreeNumber( 1, 1);
        sum *= trajectory.getTreeNumber( 3, 1);
        sum *= trajectory.getTreeNumber( 5, 1);
        sum *= trajectory.getTreeNumber( 7, 1);
        sum *= trajectory.getTreeNumber( 1, 2);

        assertEquals( 336,sum);
    }

    @Test
    public void testTraverseTaskPartTwo()
    {
        trajectory.getInput("src/main/resources/2020/day3/day3.txt");
        long sum = trajectory.getTreeNumber( 1, 1);
        sum *= trajectory.getTreeNumber( 3, 1);
        sum *= trajectory.getTreeNumber( 5, 1);
        sum *= trajectory.getTreeNumber( 7, 1);
        sum *= trajectory.getTreeNumber( 1, 2);

        assertEquals( 5872458240L,sum);
    }

}