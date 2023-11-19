(ns sicp.chapter-2.part-3.ex-2-57
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.57
;
; Extend the differentiation program to handle sums and products of arbitrary numbers of
; (two or more) terms. Then the last example above could be expressed as
;
; (deriv '(* x y (+ x 3)) 'x)
;
; Try to do this by changing only the representation for sums and products,
; without changing the deriv procedure at all.
;
; For example, the addend of a sum would be the first term, and the augend would be the sum
; of the rest of the terms.

(defn augend [s] (reduce + (drop 2 s)))
(defn make-sum [& args]
  (cond
    (empty? args) 0
    (= (count args) 1) (first args)
    (every? number? args) (reduce + args)
    :else (cons '+ args)))

(defn multiplicand [s]
  (let [last-items (drop 2 s)]
    (println last-items)
    (cond (every? number? last-items) (reduce * last-items)
          :else (cons '* last-items))))

(defn make-product [& args]
  (cond
    (empty? args) 0
    (= (count args) 1) (first args)
    (every? number? args) (reduce * args)
    :else (cons '* args)))

(defn deriv [exp var]
  (cond
    (number? exp) 0
    (b23/variable? exp) (if (b23/same-variable? exp var) 1 0)
    (b23/sum? exp) (make-sum (deriv (b23/addend exp) var)
                             (deriv (augend exp) var))
    (b23/product? exp) (make-sum
                         (make-product
                           (b23/multiplier exp)
                           (deriv (multiplicand exp) var))
                         (make-product
                           (deriv (b23/multiplier exp) var)
                           (multiplicand exp)))
    :else (throw (Exception. (str "unknown expression type: DERIV " exp)))))
