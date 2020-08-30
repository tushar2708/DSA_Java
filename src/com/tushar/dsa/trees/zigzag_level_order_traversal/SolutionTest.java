package com.tushar.dsa.trees.zigzag_level_order_traversal;

import com.tushar.dsa.trees.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(20);
        t2.left.left = new TreeNode(15);
        t2.right.right = new TreeNode(7);

        List<List<Integer>> l1 = new ArrayList<>();
        l1.add(Arrays.asList(new Integer[]{3}));
        l1.add(Arrays.asList(new Integer[]{20, 9}));
        l1.add(Arrays.asList(new Integer[]{15, 7}));

        return Arrays.asList(new Object[][]{
                {t1, l1},
                {t2, l1},
        });
    }

    private final TreeNode input;
    private final List<List<Integer>> expected;

    public SolutionTest(final TreeNode input, final List<List<Integer>> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void zigzagLevelOrder() {
        List<List<Integer>> result = new Solution().zigzagLevelOrder(input);

        Assert.assertEquals(expected, result);
    }
}
