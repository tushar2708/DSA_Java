#### Hamiltonian path:

A path in an undirected or directed graph, that visits each vertex exactly once.
If a Hamiltonian path exists, then the topological sort order is unique.

Conversely, if a topological sort doesn't form a Hamiltonian path,
the DAG will have two or more valid topological orderings.

Finding Hamiltonian path is NP complete problem. 
But we can decide if such path exists, in linear time
