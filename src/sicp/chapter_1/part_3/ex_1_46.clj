(ns sicp.chapter-1.part-3.ex-1-46
  (:require
    [sicp.misc :as m]))

; Exercise 1.46

; Several of the numerical methods described in this chapter are instances of an extremely
; general computational strategy known as iterative improvement.

; Iterative improvement says that, to compute something, we start with an initial guess
; for the answer, test if the guess is good enough, and otherwise improve the guess and
; continue the process using the improved guess as the new guess.

; Write a procedure iterative-improve that takes two procedures as arguments:
; a method for telling whether a guess is good enough and a method for improving a guess.

; Iterative-improve should return as its value a procedure that takes a guess as argument
; and keeps improving the guess until it is good enough.

; Rewrite the sqrt procedure of 1.1.7 and the fixed-point procedure of 1.3.3 in terms of iterative-improve.

(defn iterative-improve
  [enough? func-improver]
  (fn [guess]
    (if (enough? guess)
      guess
      ((iterative-improve enough? func-improver) (func-improver guess)))))

(defn sqrt-improved
  [x first-guess]
  (let [is-enough? (fn [guess] (< (abs (- (* guess guess) x)) 0.001))
        improver   (fn [guess] (m/average guess (/ x guess)))]
    ((iterative-improve is-enough? improver) first-guess)))

; (defn fixed-point-iter
;  [func-improver guess]
;  (letfn [(close-enough? [guess]
;            (< (abs (- guess (func-improver guess))) 0.001))
;    ((iterative-improve close-enough? func-improver) guess)))

(defn fixed-point-improved
  [func-improver first-guess]
  (let [close-enough? (fn [a b] (< (abs (- a b)) 0.001))]
    ((iterative-improve
       (fn [x] (close-enough? x (func-improver x)))
       func-improver) first-guess)))
