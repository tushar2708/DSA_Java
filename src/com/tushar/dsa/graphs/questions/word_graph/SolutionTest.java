package com.tushar.dsa.graphs.questions.word_graph;

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
        return Arrays.asList(new Object[][]{
                {"hit", "cog", new ArrayList<String>(List.of("hot","dot","dog","lot","log","cog")), 5},
//                {"hit", "cog", new String[]{"hot","dot","dog","lot","log"}, 0},
        });
    }

    private final String beginWord;
    private final String endWord;
    private final List<String> wordList;
    private final int expected;

    public SolutionTest(final String beginWord, final String endWord, final List<String> wordList, final int expected) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        this.wordList = wordList;
        this.expected = expected;
    }

    @Test
    public void ladderLength() {
        int actual = new Solution().ladderLength(beginWord, endWord, wordList);
        Assert.assertEquals(expected, actual);
    }
}
