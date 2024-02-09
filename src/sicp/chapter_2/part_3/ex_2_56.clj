(ns sicp.chapter-2.part-3.ex-2-56
  (:require
    [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.56
;
; Show how to extend the basic differentiator to handle more kinds of expressions.
; For instance, implement the differentiation rule
; d(u^n)/dx = n*u^(n-1)*du/dx
;
; by adding a new clause to the deriv program and defining appropriate procedures exponentiation?
; base, exponent, and make-exponentiation.(You may use the symbol ** to denote exponentiation.)
; Build in the rules that anything raised to the power 0 is 1 and anything raised to
; the power 1 is the thing itself.

(defn exponentiation?
  [x]
  (and (sequential? x) (= (first x) '**)))

(defn base
  [s]
  (second s))

(defn exponent
  [s]
  (nth s 2))

(defn make-exponentiation
  [base exponent]
  (cond
    (= exponent 0) 1.0
    (and (= exponent 1) (number? base)) (float base)
    (and (number? base) (number? exponent)) (Math/pow base exponent)
    :else (list '** base exponent)))

(defn deriv
  [exp var]
  (cond
    (number? exp) 0
    (b23/variable? exp) (if (b23/same-variable? exp var) 1 0)
    (b23/sum? exp) (b23/make-sum (deriv (b23/addend exp) var)
                                 (deriv (b23/augend exp) var))
    (exponentiation? exp) (b23/make-product
                            (b23/make-product (exponent exp)
                                              (make-exponentiation (base exp) (dec (exponent exp))))
                            (deriv (base exp) var))
    (b23/product? exp) (b23/make-sum
                         (b23/make-product
                           (b23/multiplier exp)
                           (deriv (b23/multiplicand exp) var))
                         (b23/make-product
                           (deriv (b23/multiplier exp) var)
                           (b23/multiplicand exp)))
    :else (throw (Exception. (str "unknown expression type: DERIV " exp)))))
