(ns sicp.chapter-2.part-3.ex-2-59
  (:require
    [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.59
;
; Implement the union-set operation for the unordered-list representation of sets.

(defn union-set
  [set1 set2]
  (cond
    (empty? set1) set2
    (empty? set2) set1
    (b23/element-of-set? (first set2) set1) (union-set set1 (rest set2))
    :else (union-set (concat set1 (list (first set2))) (rest set2))))
