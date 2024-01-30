(ns sicp.chapter-1.part-1.ex-1-08
  (:require [sicp.chapter-1.part-1.book-1-1 :as b11]))

; Exercise 1.8
; Newton’s method for cube roots is based on the fact that if y
; is an approximation to the cube root of x, then a better approximation is given by the value

; Use this formula to implement a cube-root procedure analogous to the square-root procedure.
; (In 1.3.4 we will see how to implement Newton’s method in general
; as an abstraction of these square-root and cube-root procedures.)

(defn improve
  [guess x]
  (/ (+ (/ x (b11/square guess))
        (* guess 2))
     3))

(defn in-delta?
  [guess1 guess2]
  (< (abs (- guess1 guess2)) 0.001))

(defn cube-root-iter
  [guess x]
  (if (in-delta? guess (improve guess x))
    guess
    (cube-root-iter (improve guess x) x)))
