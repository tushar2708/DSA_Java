#### Cycle detection
###### [Implementation](src/com/tushar/practice/graphs/cycleDetection/CycleDetector.java)

Where cycles in graph are useful?

* When I can earn money in FOREX arbitrage

Where cyccles are bad?

* When they cause an OS scheduler to freeze.

How to detect it?

While traversing a graph using DFS, if while going through any vertex's neighbours
(haven't yet backtracked from the vertex), if we find ourselves at that vertex again,
 we just confirmed a cycle









#### Topological sorting & Hamiltonian path:
###### [implementation of topological sorting](src/com/tushar/practice/graphs/topologicalSort/TopologicalSorter.java)

A path in an undirected or directed graph, that visits each vertex exactly once.
If a Hamiltonian path exists, then the topological sort order is unique.

Conversely, if a topological sort doesn't form a Hamiltonian path,
the DAG will have two or more valid topological orderings.

Finding Hamiltonian path is NP complete problem. 
But we can decide if such path exists, in linear time