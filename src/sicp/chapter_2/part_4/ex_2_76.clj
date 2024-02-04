(ns sicp.chapter-2.part-4.ex-2-76)

; Exercise 2.76
;
; As a large system with generic operations evolves, new types of data objects or new operations
; may be needed. For each of the three strategies—generic operations with explicit dispatch,
; data-directed style, and message-passing-style—describe the changes that must be made to
; a system in order to add new types or new operations. Which organization would be most appropriate
; for a system in which new types must often be added? Which would be most appropriate for
; a system in which new operations must often be added?

; Answer
;
; |------------------------|----------------------------------|-------------------------------------|
; | Style                  | Adding New Types                 | Adding New Operations               |
; |------------------------|----------------------------------|-------------------------------------|
; | Generic Operations     | Add a new branch in each         | Create a new procedure containing   |
; | with Explicit Dispatch | operation on the generic data    | the dispatch for all types          |
; |------------------------|----------------------------------|-------------------------------------|
; | Data-Directed Style    | Add the corresponding operations | Add the operation to each type      |
; |                        | into the registry table          | package and register them in table  |
; |------------------------|----------------------------------|-------------------------------------|
; | Message-Passing Style  | Implement the new type with      | Add the operation into              |
; |                        | no extra effort needed           | the implementation of each type     |
; |------------------------|----------------------------------|-------------------------------------|
; | Best Suited For        | Data-Directed Style and Message- | Explicit-Dispatch and Data-         |
; |                        | Passing Style: Systems with      | Directed Style: Systems with        |
; |                        | frequent addition of new types   | frequent addition of new operations |
; |------------------------|----------------------------------|-------------------------------------|
