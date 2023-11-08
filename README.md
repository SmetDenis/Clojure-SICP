# Solving exercises from SICP with Clojure

[![Clojure CI](https://github.com/SmetDenis/Clojure-Sicp/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/SmetDenis/Clojure-Sicp/actions/workflows/main.yml)

SICP (Structure and Interpretation of Computer Programs) is the book of Harold Abelson and Gerald
Jay Sussman on basics of computer science and software engineering.

## Based on

* [Online version](https://sarabander.github.io/sicp/)
* [SICP based on Clojure](https://www.sicpdistilled.com/)
* [Video course](https://ocw.mit.edu/courses/6-001-structure-and-interpretation-of-computer-programs-spring-2005/)

## Table of Contents

### Chapter 1 - Building Abstractions with Procedures

* [1.1](https://sarabander.github.io/sicp/html/Chapter-1.xhtml#Chapter-1) The Elements of Programming - [Code in book](src/sicp/chapter_1/part_1/book_1_1.clj)
  * [1.1.1](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e1) Expressions
  * [1.1.2](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e2) Naming and the Environment
  * [1.1.3](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e3) Evaluating Combinations
  * [1.1.4](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e4) Compound Procedures
  * [1.1.5](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e5) The Substitution Model for Procedure Application
  * [1.1.6](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e6) Conditional Expressions and Predicates - [1.1](src/sicp/chapter_1/part_1/ex_1_01.clj), [1.2](src/sicp/chapter_1/part_1/ex_1_02.clj), [1.3](src/sicp/chapter_1/part_1/ex_1_03.clj), [1.4](src/sicp/chapter_1/part_1/ex_1_04.clj), [1.5](src/sicp/chapter_1/part_1/ex_1_05.clj)
  * [1.1.7](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e7) Example: Square Roots by Newton's Method - [1.6](src/sicp/chapter_1/part_1/ex_1_06.clj), [1.7](src/sicp/chapter_1/part_1/ex_1_07.clj), [1.8](src/sicp/chapter_1/part_1/ex_1_08.clj)
  * [1.1.8](https://sarabander.github.io/sicp/html/1_002e1.xhtml#g_t1_002e1_002e8) Procedures as Black-Box Abstractions
* [1.2](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2) Procedures and the Processes They Generate - [Code in book](src/sicp/chapter_1/part_2/book_1_2.clj)
  * [1.2.1](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2_002e1) Linear Recursion and Iteration - [1.9](src/sicp/chapter_1/part_2/ex_1_09.clj), [1.10](src/sicp/chapter_1/part_2/ex_1_10.clj)
  * [1.2.2](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2_002e2) Tree Recursion - [1.11](src/sicp/chapter_1/part_2/ex_1_11.clj), [1.12](src/sicp/chapter_1/part_2/ex_1_12.clj), [1.13](src/sicp/chapter_1/part_2/ex_1_13.clj)
  * [1.2.3](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2_002e3) Orders of Growth - [1.14](src/sicp/chapter_1/part_2/ex_1_14.clj), [1.15](src/sicp/chapter_1/part_2/ex_1_15.clj)
  * [1.2.4](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2_002e4) Exponentiation - [1.16](src/sicp/chapter_1/part_2/ex_1_16.clj), [1.17](src/sicp/chapter_1/part_2/ex_1_17.clj), [1.18](src/sicp/chapter_1/part_2/ex_1_18.clj), [1.19](src/sicp/chapter_1/part_2/ex_1_19.clj)
  * [1.2.5](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2_002e5) Greatest Common Divisorsx - [1.20](src/sicp/chapter_1/part_2/ex_1_20.clj)
  * [1.2.6](https://sarabander.github.io/sicp/html/1_002e2.xhtml#g_t1_002e2_002e6) Example: Testing for Primality - [1.21](src/sicp/chapter_1/part_2/ex_1_21.clj), [1.22](src/sicp/chapter_1/part_2/ex_1_22.clj), [1.23](src/sicp/chapter_1/part_2/ex_1_23.clj), [1.24](src/sicp/chapter_1/part_2/ex_1_24.clj), [1.25](src/sicp/chapter_1/part_2/ex_1_25.clj), [1.26](src/sicp/chapter_1/part_2/ex_1_26.clj), [1.27](src/sicp/chapter_1/part_2/ex_1_27.clj), [1.28](src/sicp/chapter_1/part_2/ex_1_28.clj)
* [1.3](https://sarabander.github.io/sicp/html/1_002e3.xhtml#g_t1_002e3) Formulating Abstractions with Higher-Order Procedures - [Code in book](src/sicp/chapter_1/part_3/book_1_3.clj)
  * [1.3.1](https://sarabander.github.io/sicp/html/1_002e3.xhtml#g_t1_002e3_002e1) Procedures as Arguments - [1.29](src/sicp/chapter_1/part_3/ex_1_29.clj), [1.30](src/sicp/chapter_1/part_3/ex_1_30.clj), [1.31](src/sicp/chapter_1/part_3/ex_1_31.clj), [1.32](src/sicp/chapter_1/part_3/ex_1_32.clj), [1.33](src/sicp/chapter_1/part_3/ex_1_33.clj)
  * [1.3.2](https://sarabander.github.io/sicp/html/1_002e3.xhtml#g_t1_002e3_002e2) Constructing Procedures Using Lambda - [1.34](src/sicp/chapter_1/part_3/ex_1_34.clj)
  * [1.3.3](https://sarabander.github.io/sicp/html/1_002e3.xhtml#g_t1_002e3_002e3) Procedures as General Methods - [1.35](src/sicp/chapter_1/part_3/ex_1_35.clj), [1.36](src/sicp/chapter_1/part_3/ex_1_36.clj), [1.37](src/sicp/chapter_1/part_3/ex_1_37.clj), [1.38](src/sicp/chapter_1/part_3/ex_1_38.clj), [1.39](src/sicp/chapter_1/part_3/ex_1_39.clj)
  * [1.3.4](https://sarabander.github.io/sicp/html/1_002e3.xhtml#g_t1_002e3_002e4) Procedures as Returned Values - [1.40](src/sicp/chapter_1/part_3/ex_1_40.clj), [1.41](src/sicp/chapter_1/part_3/ex_1_41.clj), [1.42](src/sicp/chapter_1/part_3/ex_1_42.clj), [1.43](src/sicp/chapter_1/part_3/ex_1_43.clj), [1.44](src/sicp/chapter_1/part_3/ex_1_44.clj), [1.45](src/sicp/chapter_1/part_3/ex_1_45.clj), [1.46](src/sicp/chapter_1/part_3/ex_1_46.clj)

### Chapter 2 - Building Abstractions with Data

* [2.1](https://sarabander.github.io/sicp/html/Chapter-2.xhtml#Chapter-2) Introduction to Data Abstraction - [Code in book](src/sicp/chapter_2/part_1/book_2_1.clj)
  * [2.1.1](https://sarabander.github.io/sicp/html/2_002e1.xhtml#g_t2_002e1_002e1) Example: Arithmetic Operations for Rational Numbers - [2.1](src/sicp/chapter_2/part_1/ex_2_01.clj)
  * [2.1.2](https://sarabander.github.io/sicp/html/2_002e1.xhtml#g_t2_002e1_002e2) Abstraction Barriers - [2.2](src/sicp/chapter_2/part_1/ex_2_02.clj), [2.3](src/sicp/chapter_2/part_1/ex_2_03.clj)
  * [2.1.3](https://sarabander.github.io/sicp/html/2_002e1.xhtml#g_t2_002e1_002e3) What Is Meant by Data? - [2.4](src/sicp/chapter_2/part_1/ex_2_04.clj), [2.5](src/sicp/chapter_2/part_1/ex_2_05.clj), [2.6](src/sicp/chapter_2/part_1/ex_2_06.clj)
  * [2.1.4](https://sarabander.github.io/sicp/html/2_002e1.xhtml#g_t2_002e1_002e4) Extended Exercise: Interval Arithmetic - [2.7](src/sicp/chapter_2/part_1/ex_2_07.clj), [2.8](src/sicp/chapter_2/part_1/ex_2_08.clj), [2.9](src/sicp/chapter_2/part_1/ex_2_09.clj), [2.10](src/sicp/chapter_2/part_1/ex_2_10.clj), [2.11](src/sicp/chapter_2/part_1/ex_2_11.clj), [2.12](src/sicp/chapter_2/part_1/ex_2_12.clj), [2.13](src/sicp/chapter_2/part_1/ex_2_13.clj), [2.14](src/sicp/chapter_2/part_1/ex_2_14.clj), [2.15](src/sicp/chapter_2/part_1/ex_2_15.clj), [2.16](src/sicp/chapter_2/part_1/ex_2_16.clj)
* [2.2](https://sarabander.github.io/sicp/html/2_002e2.xhtml#g_t2_002e2) Hierarchical Data and the Closure Property - [Code in book](src/sicp/chapter_2/part_2/book_2_2.clj)
  * [2.2.1](https://sarabander.github.io/sicp/html/2_002e2.xhtml#g_t2_002e2_002e1) Representing Sequences - [2.17](src/sicp/chapter_2/part_2/ex_2_17.clj), [2.18](src/sicp/chapter_2/part_2/ex_2_18.clj), [2.19](src/sicp/chapter_2/part_2/ex_2_19.clj), [2.20](src/sicp/chapter_2/part_2/ex_2_20.clj), [2.21](src/sicp/chapter_2/part_2/ex_2_21.clj), [2.22](src/sicp/chapter_2/part_2/ex_2_22.clj), [2.23](src/sicp/chapter_2/part_2/ex_2_23.clj)
  * [2.2.2](https://sarabander.github.io/sicp/html/2_002e2.xhtml#g_t2_002e2_002e2) Hierarchical Structures - [2.24](src/sicp/chapter_2/part_2/ex_2_24.clj), [2.25](src/sicp/chapter_2/part_2/ex_2_25.clj), [2.26](src/sicp/chapter_2/part_2/ex_2_26.clj), [2.27](src/sicp/chapter_2/part_2/ex_2_27.clj), [2.28](src/sicp/chapter_2/part_2/ex_2_28.clj), [2.29](src/sicp/chapter_2/part_2/ex_2_29.clj), [2.30](src/sicp/chapter_2/part_2/ex_2_30.clj), [2.31](src/sicp/chapter_2/part_2/ex_2_31.clj), [2.32](src/sicp/chapter_2/part_2/ex_2_32.clj)
  * [2.2.3](https://sarabander.github.io/sicp/html/2_002e2.xhtml#g_t2_002e2_002e3) Sequences as Conventional Interfaces - [2.33](src/sicp/chapter_2/part_2/ex_2_33.clj), [2.34](src/sicp/chapter_2/part_2/ex_2_34.clj), [2.35](src/sicp/chapter_2/part_2/ex_2_35.clj), [2.36](src/sicp/chapter_2/part_2/ex_2_36.clj), [2.37](src/sicp/chapter_2/part_2/ex_2_37.clj), [2.38](src/sicp/chapter_2/part_2/ex_2_38.clj), [2.39](src/sicp/chapter_2/part_2/ex_2_39.clj), [2.40](src/sicp/chapter_2/part_2/ex_2_40.clj), [2.41](src/sicp/chapter_2/part_2/ex_2_41.clj), [2.42](src/sicp/chapter_2/part_2/ex_2_42.clj), [2.43](src/sicp/chapter_2/part_2/ex_2_43.clj)
  * [2.2.4](https://sarabander.github.io/sicp/html/2_002e2.xhtml#g_t2_002e2_002e4) Example: A Picture Language - [2.44](src/sicp/chapter_2/part_2/ex_2_44.clj), [2.45](src/sicp/chapter_2/part_2/ex_2_46.clj), [2.45](src/sicp/chapter_2/part_2/ex_2_46.clj), [2.47](src/sicp/chapter_2/part_2/ex_2_47.clj), [2.48](src/sicp/chapter_2/part_2/ex_2_48.clj)
* 2.3 Symbolic Data
  * 2.3.1 Quotation
  * 2.3.2 Example: Symbolic Differentiation
  * 2.3.3 Example: Representing Sets
  * 2.3.4 Example: Huffman Encoding Trees
* 2.4 Multiple Representations for Abstract Data
  * 2.4.1 Representations for Complex Numbers
  * 2.4.2 Tagged data
  * 2.4.3 Data-Directed Programming and Additivity
* 2.5 Systems with Generic Operations
  * 2.5.1 Generic Arithmetic Operations
  * 2.5.2 Combining Data of Different Types
  * 2.5.3 Example: Symbolic Algebra

### Chapter 3 - Modularity, Objects, and State

* 3.1 Assignment and Local State
  * 3.1.1 Local State Variables
  * 3.1.2 The Benefits of Introducing Assignment
  * 3.1.3 The Costs of Introducing Assignment
* 3.2 The Environment Model of Evaluation
  * 3.2.1 The Rules for Evaluation
  * 3.2.2 Applying Simple Procedures
  * 3.2.3 Frames as the Repository of Local State
  * 3.2.4 Internal Definitions
* 3.3 Modeling with Mutable Data
  * 3.3.1 Mutable List Structure
  * 3.3.2 Representing Queues
  * 3.3.3 Representing Tables
  * 3.3.4 A Simulator for Digital Circuits
  * 3.3.5 Propagation of Constraints
* 3.4 Concurrency: Time Is of the Essence
  * 3.4.1 The Nature of Time in Concurrent Systems
  * 3.4.2 Mechanisms for Controlling Concurrency
* 3.5 Streams
  * 3.5.1 Streams Are Delayed Lists
  * 3.5.2 Infinite Streams
  * 3.5.3 Exploiting the Stream Paradigm
  * 3.5.4 Streams and Delayed Evaluation
  * 3.5.5 Modularity of Functional Programs and Modularity of Objects

### Chapter 4 - Metalinguistic Abstraction

* 4.1 The Metacircular Evaluator
  * 4.1.1 The Core of the Evaluator
  * 4.1.2 Representing Expressions
  * 4.1.3 Evaluator Data Structures
  * 4.1.4 Running the Evaluator as a Program
  * 4.1.5 Data as Programs
  * 4.1.6 Internal Definitions
  * 4.1.7 Separating Syntactic Analysis from Execution
* 4.2 Variations on a Scheme — Lazy Evaluation
  * 4.2.1 Normal Order and Applicative Order
  * 4.2.2 An Interpreter with Lazy Evaluation
  * 4.2.3 Streams as Lazy Lists
* 4.3 Variations on a Scheme — Nondeterministic Computing
  * 4.3.1 Amb and Search
  * 4.3.2 Examples of Nondeterministic Programs
  * 4.3.3 Implementing the Amb Evaluator
* 4.4 Logic Programming
  * 4.4.1 Deductive Information Retrieval
  * 4.4.2 How the Query System Works
  * 4.4.3 Is Logic Programming Mathematical Logic?
  * 4.4.4 Implementing the Query System
    * 4.4.4.1 The Driver Loop and Instantiation
    * 4.4.4.2 The Evaluator
    * 4.4.4.3 Finding Assertions by Pattern Matching
    * 4.4.4.4 Rules and Unification
    * 4.4.4.5 Maintaining the Data Base
    * 4.4.4.6 Stream Operations
    * 4.4.4.7 Query Syntax Procedures
    * 4.4.4.8 Frames and Bindings

### Chapter 5 - Computing with Register Machines

* 5.1 Designing Register Machines
  * 5.1.1 A Language for Describing Register Machines
  * 5.1.2 Abstraction in Machine Design
  * 5.1.3 Subroutines
  * 5.1.4 Using a Stack to Implement Recursion
  * 5.1.5 Instruction Summary
* 5.2 A Register-Machine Simulator
  * 5.2.1 The Machine Model
  * 5.2.2 The Assembler
  * 5.2.3 Generating Execution Procedures for Instructions
  * 5.2.4 Monitoring Machine Performance
* 5.3 Storage Allocation and Garbage Collection
  * 5.3.1 Memory as Vectors
  * 5.3.2 Maintaining the Illusion of Infinite Memory
* 5.4 The Explicit-Control Evaluator
  * 5.4.1 The Core of the Explicit-Control Evaluator
  * 5.4.2 Sequence Evaluation and Tail Recursion
  * 5.4.3 Conditionals, Assignments, and Definitions
  * 5.4.4 Running the Evaluator
* 5.5 Compilation
  * 5.5.1 Structure of the Compiler
  * 5.5.2 Compiling Expressions
  * 5.5.3 Compiling Combinations
  * 5.5.4 Combining Instruction Sequences
  * 5.5.5 An Example of Compiled Code
  * 5.5.6 Lexical Addressing
  * 5.5.7 Interfacing Compiled Code to the Evaluator

## License

MIT
