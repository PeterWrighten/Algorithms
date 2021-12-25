# [Algorithms](https://algs4.cs.princeton.edu/home/)

All Algorithms' implementations(Obviously, without HW) has standard solutions in Course's Homepage. I would also reimplement some of them which are considered to be crucial.

**[StandardSolution](https://github.com/PeterWrighten/Algorithms/tree/main/StandardSolution)**

# Overview

[**Lecture Notes**](./Algorithms/README.md)

| Topic | Data Structure & Algorithms |
|:--:|:--:|
|Data types|**Resizing Array, Linked List;** Stack, Queue, Bag, Union-find, Priority Queue|
|Sort| **Array, BinaryHeap;** Quicksort, Mergesort, Heapsort|
|Search|**BST, Red-Black BST, HashTable**|
|**Graphs**|BFS, DFS, Prim, Kruskal, Dijkstra|
|Strings|Radix Sorts, Tries, KMP, Regexps, Data Compression|
|Advanced| B-Trees, Suffix Array, Maxflow|

# Todo List

> My implementations (Almost Original) of algo is [here](https://github.com/PeterWrighten/Algorithms/tree/main/Algorithms).

## Week 1: QuickUnion

- [x] Quickfind
- [x] Quickunion
- [ ] **Percolate**

## Week 2: Stack & Queue

- [x] Stack
- [x] Queue
- [ ] Ring Buffer
- [x] Bag:LinkedList
- [x] Bag: ResizingArray
- [ ] Queue_Resizing array
- [ ] **Randomized Queue**
- [ ] **Dequeue**
- [ ] Dijkstra

## Week 3: Sort

- [x] InsertionSort
- [x] SelectionSort
- [x] Shellsort
- [x] Mergesort: TopDown
- [ ] Mergesort: improvement
- [x] Mergesort: Bottomup
- [ ] **Collinear Points**
- [x] QuickSort
- [ ] QuickSelect
- [ ] 3-Way Quicksort 
- [x] Priority Queue
- [ ] **8 Puzzle**
- [x] Binaryheap
- [x] Heapsort
- [ ] [Option] Event-driven simulation
- [ ] Binomial Heap

### Appendix: Non-Comparison Sort

- [ ] Bucket Sort
- [ ] Counting Sort
- [ ] Radix Sort
- [ ] Intro Sort

## Week 4: Search: Table & Tree

- [ ] Sequential Search: Unordered 
- [x] Binary Search: Ordered
- [x] Binary Search Tree
- [ ] [Option] 2-3 Tree
- [x] Red-Black BSTs: A Derivative of 2-3 Tree
- [ ] [Option] B-Trees: Another Derivative of 2-3 Tree
- [ ] AVL Tree
- [ ] B Tree
- [ ] B+ Tree
- [ ] SkipList
- [ ] Hash Table:Seperate Chainning
- [ ] Hash Table: Linear Probing
- [ ] Hash Table: Rehashing

### Geometric Application  

- [ ] 1d Range Search
- [ ] Line Segment intersection
- [ ] **Kd Tree: Computer Graphics**
- [ ] Interval Search Trees
- [ ] Segment Trees


### Application

- [ ] Exception Filter: WhiteList & BlackList
- [ ] Dictionary LookUp
- [ ] File Indexing
- [ ] Sparse Vectors

## Week 5: Graph & Search

### Part 1: Undirected Graph

- [x] Graph API
- [x] Depth-First Search
- [x] Breadth-First Search
- [ ] ConnectedComponents

### Part 2: Directed Graph

- [ ] Digraph API
- [ ] Directed DFS
- [ ] DForder
- [ ] Topological Sort
- [ ] Directed Circle
- [ ] Strongly-connected Components: Kosaraju-Sharir Algorithms
- [ ] Directed BFS
- [ ] Bare-bones Web Crawler
- [ ] **Word Net**

# Problem Oriented Summary 

## Directed Graph

|Problem|Solution|
|:--:|:--:|
|Single- and multi-source reachability| DirectedDFS|
|Single-source directed paths|DepthFirstDirectedPaths|
|Single-source shortest directed paths|BreadthFirstDirectedPaths|
|Directed Cycle detection|DirectedCycle|
|Depth-first Vertex Orders|DepthFirstOrder|
|Precedence-constrained Scheduling|Topological|
|Topological Sort|Topological|
|Strong Connectivity|KosarajuSCC|
|All-pairs Reachability|TransitiveClosure|


