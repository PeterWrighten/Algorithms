# [Algorithms](https://algs4.cs.princeton.edu/home/)

All Algorithms' implementations(Obviously, without HW) has standard solutions in Course's Homepage. I would also reimplement some of them which are considered to be crucial.

**[StandardSolution](https://github.com/PeterWrighten/Algorithms/tree/main/StandardSolution)**

# Overview

[**Lecture Notes**](./MyAlgorithms/README.md)

| Topic | Data Structure & Algorithms |
|:--:|:--:|
|Data types|**Resizing Array, Linked List;** Stack, Queue, Bag, Union-find, Priority Queue|
|Sort| **Array, BinaryHeap;** Quicksort, Mergesort, Heapsort|
|Search|**BST, Red-Black BST, HashTable**|
|**Graphs**|BFS, DFS, Prim, Kruskal, Dijkstra|
|Strings|Radix Sorts, Tries, KMP, Regexps, Data Compression|
|Advanced| B-Trees, Suffix Array, Maxflow|

# Todo List

> My implementations (Almost Original) of algo is [here](https://github.com/PeterWrighten/Algorithms/tree/main/MyAlgorithms).

## Week 1: UnionFind

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

## Week 3: Sorting

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
- [ ] Time-Dirven Simulation: Bouncing Ball
- [ ] [Option] Event-driven simulation
- [ ] Binomial Heap

### Appendix: Non-Comparison Sort

- [ ] Bucket Sort
- [ ] Counting Sort
- [ ] Radix Sort
- [ ] Intro Sort

## Week 4: Search: Symbol Table

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

## Week 5: Search: Graph

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

## Week 6: EdgeWeighted Graph & Optimization

### Part 1: Undirected Graph

#### Minimum Spanning Tree

- [x] Weighted-Edge API
- [ ] Edge-Weighted Graph API
- [ ] Minimus Spanning Tree
- [ ] Union-Find API
- [ ] Kruskal's Algorithm
- [ ] LazyPrim's Algorithms
- [ ] Indexed PQ API
- [ ] EagerPrim's Algorithms
- [ ] Clustering Algorithm: K-Mean/KNN

### Part 2: Directed Graph

#### Shortest Path

- [x] DirectedEdge
- [x] EdgeWeightedDigraph
- [ ] Single-source shortest paths API
- [ ] Dijkstra Algorithm: Nonnegative Weight
- [ ] Acyclic Shortest Paths
- [ ] **Seam Carving**
- [ ] Bellman-Ford Algorithm: No negative Cycle

#### Mincut & Maxflow



# Application Oriented Summary 

## Computer Graphics

|APP|Solution|Type|
|:--:|:--:|:--:|
|Video Game Shoot Aid|Kd Tree|Symbol Table|
|Event-driven Simulation|Priority Queue|Binary Heap|

## Computer Network

|APP|Solution|Type|
|:--:|:--:|:--:|
|Web Crawler|Breadth First Search|Directed Graph|
|Routing[1]|Dijkstra Algorithm|Directed Weighted Graph|
|Routing[2]|Bellman Ford|Directed Weighted Graph|

## Operating System

|APP|Solution|Type|
|:--:|:--:|:--:|
|FileSystem|RedBlackTree|Symbol Table|
|Scheduling|Topological Sort|DAG|

## Programming Language (Compiler)

|APP|Solution|Type|
|:--:|:--:|:--:|
|Mark-sweep Garbage Collection|Depth First Search|Digraph|
|Cyclic inheritance|Depth First Search|DAG|

## Database

|APP|Solution|Type|
|:--:|:--:|:--:|
|File Organization|B+ Tree|Symbol Table|

## AI 

|APP|Solution|Type|
|:--:|:--:|:--:|
|Supervised Learning: Classification|KNN|Minimum Spanning Tree|
|Unsupervised Learning: Clustering|K-Mean|Minimum Spanning Tree|

## Application

|APP|Solution|Type|
|:--:|:--:|:--:|
|Flooding|Depth First Search|Photo Processing|
|Seam Carving|Dijkstra's Algorithm|Photo Processing|

