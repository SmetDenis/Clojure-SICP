(ns sicp.chapter-1.part_1.ex-1-6
  (:require [sicp.chapter-1.part-1.book-1-1 :as book]))

; Exercise 1.6
; Alyssa P. Hacker doesn’t see why if needs to be provided as a special form.
; “Why can’t I just define it as an ordinary procedure in terms of cond?” she asks.
; Alyssa’s friend Eva Lu Ator claims this can indeed be done, and she defines a new version of if:

(defn new-if
  [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

; Eva demonstrates the program for Alyssa:
(new-if (= 2 3) 0 5)                                        ; 5
(new-if (= 1 1) 0 5)                                        ; 0

; Delighted, Alyssa uses new-if to rewrite the square-root program:

(defn sqrt-iter-new-if
  [guess x]
  (new-if (book/good-enough? guess x)
          guess
          (book/sqrt-iter (book/improve guess x) x)))

; What happens when Alyssa attempts to use this to compute square roots? Explain.
; TODO Explain.
