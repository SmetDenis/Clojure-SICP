(ns sicp.chapter-2.part-3.ex-2-61
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.61
;
; Give an implementation of adjoin-set using the ordered representation.
; By analogy with element-of-set? show how to take advantage of the ordering to produce
; a procedure that requires on the average about half as many steps as with the unordered representation.

(defn adjoin-set-sorted [x set]
  (if (b23/element-of-set-sorted? x set)
    set
    (cons x set)))
