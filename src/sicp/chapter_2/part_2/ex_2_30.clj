(ns sicp.chapter-2.part-2.ex-2-30
  (:require
    [sicp.misc :as m]))

; Exercise 2.30
;
; Define a procedure square-tree analogous to the square-list procedure of Exercise 2.21.
; That is, square-tree should behave as follows:
;
; (square-tree
;  (list 1
;        (list 2 (list 3 4) 5)
;        (list 6 7)))
;
; (1 (4 (9 16) 25) (36 49))
;
; Define square-tree both directly (i.e., without using any higher-order procedures)
; and also by using map and recursion.

(defn square-tree
  [tree]
  (cond (m/list-empty? tree) nil
        (m/leaf? tree) (m/square tree)
        :else (cons (square-tree (first tree))
                    (square-tree (rest tree)))))

(defn square-tree-map
  [tree]
  (map (fn [sub-tree]
         (if (list? sub-tree)
           (square-tree-map sub-tree)
           (m/square sub-tree)))
       tree))
