(ns sicp.chapter-2.part-1.ex-2-07
  (:require
    [sicp.misc :as m]))

; Exercise 2.7
; Alyssa’s program is incomplete because she has not specified
; the implementation of the interval abstraction.
; Here is a definition of the interval constructor:
; (define (make-interval a b) (cons a b))
; Define selectors upper-bound and lower-bound to complete the implementation.

(defn make-interval
  [low high]
  (m/pair low high))

(defn lower-bound
  [interval]
  (m/car interval))

(defn upper-bound
  [interval]
  (m/cdr interval))
