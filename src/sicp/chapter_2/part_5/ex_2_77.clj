(ns sicp.chapter-2.part-5.ex-2-77
  (:require
    [sicp.chapter-2.packages.op-table :as ot]))

; Exercise 2.77
;
; Louis Reasoner tries to evaluate the expression (magnitude z) where z is the object shown in
; Figure 2.24. To his surprise, instead of the answer 5 he gets an error message from apply-generic,
; saying there is no method for the operation magnitude on the types (complex).
;
; He shows this interaction to Alyssa P. Hacker, who says “The problem is that the complex-number
; selectors were never defined for complex numbers, just for polar and rectangular numbers.
; All you have to do to make this work is add the following to the complex package:”
;
; (put 'real-part '(complex) real-part)
; (put 'imag-part '(complex) imag-part)
; (put 'magnitude '(complex) magnitude)
; (put 'angle '(complex) angle)

(defn magnitude
  [z]
  (ot/apply-generic :magnitude z))
