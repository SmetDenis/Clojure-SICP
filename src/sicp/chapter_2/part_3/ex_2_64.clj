(ns sicp.chapter-2.part-3.ex-2-64
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.64
;
; The following procedure list->tree converts an ordered list to a balanced binary tree.
; The helper procedure partial-tree takes as arguments an integer n and list of at least n
; elements and constructs a balanced tree containing the first n elements of the list.
; The result returned by partial-tree is a pair (formed with cons) whose car is the constructed tree
; and whose cdr is the list of elements not included in the tree.
;
; (define (list->tree elements)
;   (car (partial-tree
;         elements (length elements))))
;
; (define (partial-tree elts n)
;   (if (= n 0)
;       (cons '() elts)
;       (let ((left-size
;              (quotient (- n 1) 2)))
;         (let ((left-result
;                (partial-tree
;                 elts left-size)))
;           (let ((left-tree
;                  (car left-result))
;                 (non-left-elts
;                  (cdr left-result))
;                 (right-size
;                  (- n (+ left-size 1))))
;             (let ((this-entry
;                    (car non-left-elts))
;                   (right-result
;                    (partial-tree
;                     (cdr non-left-elts)
;                     right-size)))
;               (let ((right-tree
;                      (car right-result))
;                     (remaining-elts
;                      (cdr right-result)))
;                 (cons (make-tree this-entry
;                                  left-tree
;                                  right-tree)
;                       remaining-elts))))))))

(defn partial-tree [elts n]
  (if (= n 0)
    (list '() elts)
    (let [left-size      (quot (- n 1) 2)
          left-result    (partial-tree elts left-size)
          left-tree      (first left-result)
          non-left-elts  (second left-result)
          right-size     (- n (+ left-size 1))
          this-entry     (first non-left-elts)
          right-result   (partial-tree (rest non-left-elts) right-size)
          right-tree     (first right-result)
          remaining-elts (second right-result)]
      (list (b23/make-tree this-entry left-tree right-tree) remaining-elts))))

(defn list->tree [elements]
  (first (partial-tree elements (count elements))))

; 1. Write a short paragraph explaining as clearly as you can how partial-tree works.
; Draw the tree produced by list->tree for the list (1 3 5 7 9 11).
; Answer: It has been done in test/sicp/chapter_2/part_3/ex_2_64_test.clj

; 2. What is the order of growth in the number of steps required by list->tree
; to convert a list of n elements?)
; Answer: O(n)
