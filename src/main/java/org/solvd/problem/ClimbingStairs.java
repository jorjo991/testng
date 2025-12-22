package org.solvd.problem;

public class ClimbingStairs {

    /* You are climbing a staircase. it takes n steps to reach the top.
     each time you can either climb 1 or 2 steps.
     question: How many distinct ways are there to reach the top?
     */
    public static int climbStairs(int n) {
        if (n > 1000) throw new IndexOutOfBoundsException("Too large input");
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (n == 0) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1001));
    }
}
