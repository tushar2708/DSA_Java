package com.tushar.dsa.arrays;

import org.junit.Assert;
import org.junit.Test;

public class CoPrimeTest {

    @Test
    public void findLowestCoPrime1() {
        Assert.assertEquals(2, CoPrime.findLowestCoPrime(new int[]{5, 7, 25}));
    }

    @Test
    public void findLowestCoPrime2() {
        Assert.assertEquals(5, CoPrime.findLowestCoPrime(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void findLowestCoPrime3() {
        Assert.assertEquals(5, CoPrime.findLowestCoPrime(new int[]{1, 2, 3, 4, 6}));
    }

    @Test
    public void findLowestCoPrime4() {
        Assert.assertEquals(5, CoPrime.findLowestCoPrime(new int[]{1, 3, 10, 6}));
    }
}
