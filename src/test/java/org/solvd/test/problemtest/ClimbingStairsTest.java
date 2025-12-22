package org.solvd.test.problemtest;

import org.solvd.problem.ClimbingStairs;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClimbingStairsTest {

    @DataProvider(name = "climbStairsData")
    public Object[][] climbStairsData() {
        return new Object[][]{
                {-1, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 5},
                {5, 8},
        };
    }

    @Test(dataProvider = "climbStairsData")
    public void climbStairsTest(int input, int expected) {
        assertEquals(ClimbingStairs.climbStairs(input), expected);
    }

    @Test(testName = "invalid input", expectedExceptions = IndexOutOfBoundsException.class)
    public void climbStairsInvalidInputTest() {
        ClimbingStairs.climbStairs(1001);
    }
}
