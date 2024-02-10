(ns sicp.chapter-1.part-3.ex-1-39
  (:require
    [sicp.chapter-1.part-3.ex-1-37 :as ex-1-37]))

; Exercise 1.39
; A continued fraction representation of the tangent function was published in 1770
; by the German mathematician J.H. Lambert: tan(x) = x / (1 - x^2/3 + x^2/5 - ...)
; where x is in radians. Define a procedure (tan-cf x k) that computes an approximation to
; the tangent function based on Lambert’s formula.
; k specifies the number of terms to compute, as in Exercise 1.37.

(defn tan-cf
  [x k]
  (ex-1-37/cont-frac-iter
    (fn [i]
      (if (= i 1)
        x
        (- (Math/pow x 2))))
    (fn [i] (- (* 2.0 i) 1))
    k))
