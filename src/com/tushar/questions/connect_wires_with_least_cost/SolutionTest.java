package com.tushar.questions.connect_wires_with_least_cost;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void findLowestPossibleCost() {
        int[] wires = {13, 5, 6, 7, 1, 9, 2};

        int minCost = Solution.findLowestPossibleCost(wires);

        System.out.println("minCost: " + minCost);

        Assert.assertEquals(153, minCost);
    }

}
