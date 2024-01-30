(ns sicp.chapter-1.part-2.ex-1-09)

; Exercise 1.9
; Each of the following two procedures defines a method for adding two positive integers
; in terms of the procedures inc, which increments its argument by 1, and dec, which decrements its argument by 1.

(defn plus
  [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))                                   ; linear recursive

(defn plus-v2
  [a b]
  (if (= a 0)
    b
    (+ (dec a) (inc b))))                                   ; linear iteration

; Using the substitution model, illustrate the process generated by each procedure in evaluating (+ 4 5).
; Are these processes iterative or recursive?
