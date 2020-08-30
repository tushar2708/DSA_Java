package com.tushar.dsa.arrays.big_int_multiplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                new String[]{"2","3", "6"},
                new String[]{"123","456", "56088"},
                new String[]{"7","8", "56"},
        });
    }

    private final String num1;
    private final String num2;
    private final String expected;

    public SolutionTest(final String num1, final String num2, final String expected) {
        this.num1 = num1;
        this.num2 = num2;
        this.expected = expected;
    }

    @Test
    public void multiply() {
        String actual = new Solution().multiply(num1, num2);
        Assert.assertEquals(expected, actual);
    }
}
