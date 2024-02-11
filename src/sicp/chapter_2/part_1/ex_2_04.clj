(ns sicp.chapter-2.part-1.ex-2-04)

; Exercise 2.4
;
; Here is an alternative procedural representation of pairs.
; For this representation, verify that (car (cons x y)) yields x for any objects x and y.
; (define (cons x y)
;   (lambda (m) (m x y)))
;
; (define (car z)
;   (z (lambda (p q) p)))

; What is the corresponding definition of cdr?
; (Hint: To verify that this works, make use of the substitution model of 1.1.5.)

(defn pair
  [x y]
  (fn [m] (m x y)))

(defn car
  [z]
  (z (fn [p _] p)))

(defn cdr
  [z]
  (z (fn [_ q] q)))
