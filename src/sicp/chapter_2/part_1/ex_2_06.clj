(ns sicp.chapter-2.part-1.ex-2-06)

; Exercise 2.6
;
; In case representing pairs as procedures wasn’t mind-boggling enough, consider that,
; in a language that can manipulate procedures, we can get by without numbers
; (at least insofar as nonnegative integers are concerned) by implementing 0
; and the operation of adding 1 as
;
; (define zero (lambda (f) (lambda (x) x)))
;
; (define (add-1 n)
;   (lambda (f) (lambda (x) (f ((n f) x)))))
;
; This representation is known as Church numerals, after its inventor, Alonzo Church,
; the logician who invented the λ-calculus.
;
; Define one and two directly (not in terms of zero and add-1).
; (Hint: Use substitution to evaluate (add-1 zero)).
;
; Give a direct definition of the addition procedure +
; (not in terms of repeated application of add-1).

(def zero (fn [_] (fn [x] x)))
(def one (fn [f] (fn [x] (f x))))
(def two (fn [f] (fn [x] (f (f x)))))

(defn add-1
  [next-item-fn]
  (fn [f] (fn [x] (f ((next-item-fn f) x)))))

(defn add
  [num-1 num-2]
  (fn [f]
    (fn [x]
      ((num-1 f)
       ((num-2 f) x)))))
