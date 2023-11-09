(ns sicp.chapter-1.part-3.ex-1-31)

; Exercise 1.31

; 1. The sum procedure is only the simplest of a vast number of similar abstractions
; that can be captured as higher-order procedures.

; Write an analogous procedure called product that returns the product of the values
; of a function at points over a given range. Show how to define factorial in terms of product.

; Also use product to compute approximations to π using the formula
; π/4 = 2⋅4⋅4⋅6⋅6⋅8⋅... / 3⋅3⋅5⋅5⋅7⋅7⋅...

; 2. If your product procedure generates a recursive process, write one that generates an iterative process.
; If it generates an iterative process, write one that generates a recursive process.

(defn john-wallis-term-for-pi-4
  [x]
  (if (even? x) (/ x (inc x)) (/ (inc x) x)))

; ---------
; 1.
(defn product
  [term a next-fn b]
  (if (> a b)
    1
    (* (term a)
       (product term (next-fn a) next-fn b))))

(defn factorial
  [x]
  (product identity 1 inc x))

(defn pi
  [precision]
  (* 4.0 (product john-wallis-term-for-pi-4 2 inc precision)))

; ---------
; 2.
(defn product-iter
  [term a next-fn b]
  (letfn [(iter [a result]
            (if (> a b)
              result
              (iter (next-fn a) (* (term a) result))))]
    (iter a 1)))

(defn pi-iter
  [precision]
  (* 4.0 (product-iter john-wallis-term-for-pi-4 2 inc precision)))
