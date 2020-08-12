package com.tushar.dsa.moving_window.smallest_substring_with_all_unique_characters;

import org.junit.Assert;
import org.junit.Test;

public class MinSizedUniqueElementsSubarrayTest {

    @Test
    public void test1() {
        int ans = new MinSizedUniqueElementsSubarray().minLengthSa(new char[]{
                'd', 'b', 'b', 'b', 'a',
                'c', 'c', 'd', 'd', 'd',
                'b', 'b', 'a', 'a', 'c',
                'd', 'b'});
        Assert.assertEquals(4, ans);
    }

}
