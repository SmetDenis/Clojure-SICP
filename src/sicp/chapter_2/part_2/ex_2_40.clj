(ns sicp.chapter-2.part-2.ex-2-40
  (:require [sicp.chapter-2.part-2.book-2-2 :as b22]
            [sicp.misc :as m]))

; Exercise 2.40
;
; Define a procedure unique-pairs that, given an integer n, generates the sequence of pairs (i,j)
; with 1 <= j < i <= n.
;
; Use unique-pairs to simplify the definition of prime-sum-pairs given above.

(defn unique-pairs [n]
  (b22/flatmap
    (fn [i]
      (map (fn [j] (list i j))
           (b22/enumerate-interval 1 (- i 1))))
    (b22/enumerate-interval 1 n)))

(defn prime-sum-pairs [n]
  (map b22/make-pair-sum
       (filter b22/prime-sum?
               (unique-pairs n))))
