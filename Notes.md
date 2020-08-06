## Some useful notes on different topics:

#Sections

## Graphs:

### Cycle detection
#### [Implementation](src/com/tushar/dsa/graphs/dfs_cycleDetection/CycleDetector.java)

Where cycles in graph are useful?

* When I can earn money in FOREX arbitrage

Where cycles are bad?

* When they cause an OS scheduler to freeze.

How to detect it?

While traversing a graph using DFS, if while going through any pathVertex's neighbours
(haven't yet backtracked from the pathVertex), if we find ourselves at that pathVertex again,
 we just confirmed a cycle

### Maze solving
#### [Implementation](src/com/tushar/dsa/graphs/dfs_mazeSolve/MazeSolver.java)

* Run a DFS, while considering out-of-map, and visited as backtracking conditions.
* If you reach a cell with desired properties, then the search is complete. 

### Shortest Path Algorithms:
#### Dijkstra's algorithm:

**Time complexity**: O(V*logV + E)

**Type** : Greedy algo- At every iteration, tries to find the shortest distance to next vertices.

**Steps** : A DS like heap(priority queue) is used for this purpose.
Djikstra is basically, BFS with a priority queue, instead of a FIFO queue.

Usable for positive edge-weight scenario.
Can give A->B shortest path, as well as A->all nodes shortest path tree.

Pros
Asymptotically fastest known single-source shortest-path algorithm.

Problems:
Computation can't be reused if the source changes

#### Bellman-Ford algorithm:

**Time complexity**: O(V * E)

**Type**: Dynamic programming

**Steps**: 
Iterate over all the edges and relax their vertices, repeat it (V-1) times

Pros:
Usable for negative edge weights as well, 
but can't find shortest path with negative weight cycle

Cons:
Slower than Dijkstra's algorithm
 
#### DAG shortest path algorithm algorithm:

Faster than both other algorithms, if the graph is a DAG 

**Time complexity**: O(E + V)

**Type**: Depth first search

**Steps**: 
1. Topologically sort the DAG.
2. Start relaxing the vertices in topologically sorted order.

#### Topological sorting & Hamiltonian path:
##### [implementation of topological sorting](src/com/tushar/dsa/graphs/dfs_topologicalSort/TopologicalSorter.java)

A path in an undirected or directed graph, that visits each pathVertex exactly once.
If a Hamiltonian path exists, then the topological sort order is unique.

Conversely, if a topological sort doesn't form a Hamiltonian path,
the DAG will have two or more valid topological orderings.

Finding Hamiltonian path is NP complete problem. 
But we can decide if such a path exists, in linear time.


### Disjoint Sets:

Also called union-find DS.

Used to keep track of a set of elements partitioned into disjoint (non-overlapping) sets.

Support 3 operations:

* union
* find
* makeSet

Can be represented as either linked list or tree-like structure(preferred).

#### Usage
* In Kruskal algorithm, it tells if 2 vertices are in same set or not, in order O(1)
* Mostly this concept is used as part of some other data-structure, and not separately.

There are 2 optimizations, to keep this tree balanced:
1. Union by rank: Make the one with higher rank, as the parent of the node with lower rank.
2. Path compression: Flattening while find(), connecting each visited node to the root directly.

Merge/union is always done with representative.


### Spanning Tree

* **Most important**: MST only applies to undirected graphs.
* A sub-graph, that includes all the vertices of the graph, but not necessarily all the edges.
* A graph may have multiple spanning trees.
* Minimum spanning tree is a tree with minimum weight across all possible spanning trees.

**Algorithms**  :

Greedy: Kruskal's & Prim's

##### Kruskal's Minimum Spanning Tree Algorithm:

**Type**: Greedy algorithm

* Edge based MST creation.
* Result of algorithm doesn't change, if a fixed number is added or multiplied to edge weights. 

**Time complexity**: O(E * logE) , where E -> edge

**Steps**:
1. Sort all the edges in increasing order of weights. `O(N*logN)` . 
A heap can also be used, but the complexity stays the same.
2. Iterate through all the edges, starting with the smallest weight one. `O(n)`
3. If source & target of edges don't fall in the same disjoint set( `O(1)` to check this),
 add that edge to MST & merge the sets ( `O(1)` to merge), else ignore it.
 
#### Prim's algorithm MST Algorithm

**Type**: Greedy algorithm

* Vertex based MST creation

**Time complexity**: O(E * logE) --> E -> edge. Worst case: O(E * logV)

**How is it different from Kruskal's algo?**
Ans: We build MST, by starting from a given vertex. By adding the smallest edge to MST.

#### **Prim's v/s Kruskal**
1. Prim's algorithm is faster, for a dense graph that has more edges than vertices.
2. Kruskal performs better in case of a sparse graph.
3. Kruskal can perform better, if edges can be sorted in linear time,
 or if they are already sorted

There are 2 types of Prim's algorithms:
1. Lazy Prim's : Add new neighbour edges to the heap, without deleting its content.
2. Eager Prim's : Heap's content is updated and improved,
 if it's possible to get a shorter path to any vertex.
 
* Applications of spanning trees:
1. Big data analysis, clustering algorithms, minimum cost of laying cables.
2. Optimization problems:
    * We have N cities, we need to make sure every city can be reached by road
    * We need MST to connect all cities, with least possible cost.
    * Similarly, internet connections, electricity lines, or motorways.
3. k-means Clusterig:
    * Classification of similar items. Eg. dots in 2D plane.
    * Dots closer to each other, compared to other dots, will be in the same cluster.
    * Solution: We make a MST, and then remove the N-1 most expensive edges,
      to make N clusters.
    * Useful for unsupervised learning. Eg for stock/forex market, clothing market.
4. Routing in LAN:
    * Spanning tree protocol (STP) ensures a loop-free topology for any bridged LAN.
    * Spanning tree topology ensures that bridge can discover a subset of the topology,
    that is loop-free (basically MST)
    * STP also ensures connectivity to all points.

### Strongly Connected Components

Connected graph: All its vertices are connected.
Strongly Connected graph: Can reach from any vertex to any other vertex
1. Undirected graphs are always strongly connected.
2. In directed graphs, there are vertices that cannot be reached from everywhere.
3. These strongly connected clusters can be found by DFS, in O(V) time.
4. Fun fact: If we represent each strongly connected component as a node,
 resultant graph would be a DAG.
5. A directed graph is a DAG, only if there is no sub-graph that is strongly connected.
6. Every non-trivial strongly-connected component Directed cycle 

Applications of connected components:
Ecology: Determine hierarchy of food need
Software dev: Create related paackages
Astrophysics: Grouping stars into clusters
Recommendation systems: youtube videos

##### Algorithms for Connected components:

##### Kosaraju algorithm:

1. Do DFS in the graph, and keep pushing the nodes to a stack. (just like topological sort)
2. Transpose the graph, reverse the edges. (create a copy)
3. Keep popping the nodes from the stack, and run DFS starting from that node, to get it's STC


/*
Time complexity:
1st DFS for topological sort: O(V+E)
Reverse the graph: O(V+E)
2nd DFS for graph: O(V+E)

 */

##### Tarjan algorithm:









