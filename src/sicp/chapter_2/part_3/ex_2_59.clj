(ns sicp.chapter-2.part-3.ex-2-59
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.59
;
; Implement the union-set operation for the unordered-list representation of sets.

(defn union-set [set1 set2]
  (cond
    (or (empty? set1) (empty? set2)) '()
    (not (b23/element-of-set? (first set2) set1))
    (concat (union-set set1 (list (first set2))) (rest set2))
    :else (union-set set1 (rest set2))))

(println (union-set '(1 2 3) '(3 4 5 1 2 7 8 9)))
