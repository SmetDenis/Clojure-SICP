(ns sicp.chapter-1.part-3.ex-1-40)

; Exercise 1.40
; Define a procedure cubic that can be used together
; with the newtons-method procedure in expressions of the form
;
; (newtons-method (cubic a b c) 1)
; to approximate zeros of the cubic x^3 + ax^2 + bx +c.

(defn cubic
  [a b c]
  (fn [x]
    (+ (* x x x)
       (* a x x)
       (* b x)
       c)))
