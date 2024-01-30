(ns sicp.chapter-2.part-3.ex-2-63
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.63
;
; Each of the following two procedures converts a binary tree to a list.
;
; (define (tree->list-1 tree)
;   (if (null? tree)
;       '()
;       (append
;        (tree->list-1
;         (left-branch tree))
;        (cons (entry tree)
;              (tree->list-1
;               (right-branch tree))))))
;
; (define (tree->list-2 tree)
;   (define (copy-to-list tree result-list)
;     (if (null? tree)
;         result-list
;         (copy-to-list
;          (left-branch tree)
;          (cons (entry tree)
;                (copy-to-list
;                 (right-branch tree)
;                 result-list)))))
;   (copy-to-list tree '()))

(defn tree->list-1 [tree]
  (if (empty? tree)
    '()
    (concat
      (tree->list-1 (b23/left-branch tree))
      (cons (b23/entry tree)
            (tree->list-1 (b23/right-branch tree))))))

(defn tree->list-2 [tree]
  (letfn [(copy-to-list [tree result-list]
            (if (empty? tree)
              result-list
              (copy-to-list
                (b23/left-branch tree)
                (cons (b23/entry tree)
                      (copy-to-list
                        (b23/right-branch tree)
                        result-list)))))]
    (copy-to-list tree '())))

; 1. Do the two procedures produce the same result for every tree? If not, how do the results differ?
; What lists do the two procedures produce for the trees in Figure 2.16?
; Answer: The same result is produced for every tree.
; See test/sicp/chapter_2/part_3/ex_2_63_test.clj.

; 2. Do the two procedures have the same order of growth in the number of steps required to convert
; a balanced tree with n elements to a list? If not, which one grows more slowly?
; Answer:
; tree->list-1 gives O(n*logn) because append (concat) is O(n) and it is called for each node.
; tree->list-2 gives O(n) because cons in copy-to-list is O(1) and it is called for each node.
; So tree->list-2 grows more slowly.
