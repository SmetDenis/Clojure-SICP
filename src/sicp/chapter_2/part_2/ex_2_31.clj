(ns sicp.chapter-2.part-2.ex-2-31
  (:require
    [sicp.misc :as m]))

; Exercise 2.31
;
; Abstract your answer to Exercise 2.30 to produce a procedure tree-map with the property
; that square-tree could be defined as
;
; (define (square-tree tree)
;   (tree-map square tree))

(defn tree-map
  [term tree]
  (map (fn [sub-tree]
         (if (list? sub-tree)
           (tree-map term sub-tree)
           (term sub-tree)))
       tree))

(defn square-tree
  [tree]
  (tree-map m/square tree))
