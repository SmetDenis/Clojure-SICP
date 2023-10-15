(ns sicp.chapter-1.ex-1-3)

; Exercise 1.3
; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two
; larger numbers.

(defn sum-larger-numbers-square
  [x y z]
  (cond (and (< x y) (< x z)) (+ (* y y) (* z z))
        (and (< y x) (< y z)) (+ (* x x) (* z z))
        :else (+ (* x x) (* y y))))
