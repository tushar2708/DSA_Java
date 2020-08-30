package com.tushar.dsa.graphs.questions.clone_graph;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void cloneGraph() {
        Solution s = new Solution();
        Solution.Node n1 = s.newNode(1);
        Solution.Node n2 = s.newNode(2);
        Solution.Node n3 = s.newNode(3);
        Solution.Node n4 = s.newNode(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n3);
        n2.neighbors.add(n1);

        n3.neighbors.add(n4);
        n3.neighbors.add(n2);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        new Solution().cloneGraph(n1);
    }
}
