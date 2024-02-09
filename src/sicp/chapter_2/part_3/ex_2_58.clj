(ns sicp.chapter-2.part-3.ex-2-58
  (:require
    [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.58
;
; Suppose we want to modify the differentiation program so that it works with ordinary mathematical
; notation, in which + and * are infix rather than prefix operators.
; Since the differentiation program is defined in terms of abstract data, we can modify it to work
; with different representations of expressions solely by changing the predicates, selectors,
; and constructors that define the representation of the algebraic expressions on which the
; differentiator is to operate.
;
; 1. Show how to do this in order to differentiate algebraic expressions presented in infix form,
; such as (x + (3 * (x + (y + 2)))). To simplify the task, assume that + and * always take two
; arguments and that expressions are fully parenthesized.
;
; 2. The problem becomes substantially harder if we allow standard algebraic notation,
; such as (x + 3 * (x + y + 2)), which drops unnecessary parentheses and assumes that multiplication
; is done before addition. Can you design appropriate predicates, selectors, and constructors
; for this notation such that our derivative program still works?

(defn sum?
  [x]
  (and (sequential? x) (= (second x) '+)))

(defn addend
  [s]
  (first s))

(defn augend
  [e]
  (if-not (nil? (nth e 3 nil)) (drop 2 e) (nth e 2)))

(defn make-sum
  [a1 a2]
  (cond
    (zero? a1) a2
    (zero? a2) a1
    (and (number? a1) (number? a2)) (+ a1 a2)
    :else (list a1 '+ a2)))

(defn product?
  [x]
  (and (sequential? x) (= (second x) '*)))

(defn multiplier
  [p]
  (first p))

(defn multiplicand
  [e]
  (if-not (nil? (nth e 3 nil)) (drop 2 e) (nth e 2)))

(defn make-product
  [m1 m2]
  (cond (or (b23/=number? m1 0) (b23/=number? m2 0)) 0
        (b23/=number? m1 1) m2
        (b23/=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))

(defn deriv
  [exp var]
  (cond
    (number? exp) 0
    (b23/variable? exp) (if (b23/same-variable? exp var) 1 0)
    (sum? exp) (make-sum (deriv (addend exp) var)
                         (deriv (augend exp) var))
    (product? exp) (make-sum
                     (make-product
                       (multiplier exp)
                       (deriv (multiplicand exp) var))
                     (make-product
                       (deriv (multiplier exp) var)
                       (multiplicand exp)))
    :else (throw (Exception. (str "unknown expression type: DERIV " exp)))))
