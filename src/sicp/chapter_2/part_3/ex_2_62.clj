(ns sicp.chapter-2.part-3.ex-2-62)

; Exercise 2.62.
;
; Give a O(n) implementation of union-set for sets represented as ordered lists.

(defn union-set-sorted [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :else (let [x1 (first set1) x2 (first set2)]
                (cond (= x1 x2) (cons x1 (union-set-sorted (rest set1) (rest set2)))
                      (< x1 x2) (cons x1 (union-set-sorted (rest set1) set2))
                      :else (cons x2 (union-set-sorted set1 (rest set2)))))))
