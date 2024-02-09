(ns sicp.chapter-2.part-1.ex-2-05
  (:require
    [sicp.misc :as m]))

; Exercise 2.5
;
; Show that we can represent pairs of nonnegative integers
; using only numbers and arithmetic operations if we represent the pair a and b as the integer
; that is the product 2a3b.
;
; Give the corresponding definitions of the procedures cons, car, and cdr.

(defn pair
  [x y]
  (* (Math/pow 2 x)
     (Math/pow 3 y)))

(defn car
  [z]
  (loop [x z count 0 divisor 2]
    (if (m/divides? divisor x)
      (recur (/ x divisor) (inc count) divisor)
      count)))

(defn cdr
  [z]
  (loop [x z count 0 divisor 3]
    (if (m/divides? divisor x)
      (recur (/ x divisor) (inc count) divisor)
      count)))
