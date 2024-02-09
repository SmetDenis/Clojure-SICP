(ns sicp.chapter-1.part-3.ex-1-45
  (:require
    [sicp.chapter-1.part-3.book-1-3 :as b13]
    [sicp.chapter-1.part-3.ex-1-43 :as ex-1-43]))

; Exercise 1.45
;
; We saw in 1.3.3 that attempting to compute square roots by naively finding a
; fixed point of y->x/y does not converge, and that this can be fixed by average damping.
;
; The same method works for finding cube roots as fixed points of the average-damped y↦x/y^2.
; Unfortunately, the process does not work for fourth roots—a single average damp is not enough
; to make a fixed-point search for y->x/y^3 converge.
;
; On the other hand, if we average damp twice (i.e., use the average damp of the average damp
; of y->x/y^3) the fixed-point search does converge.
;
; Do some experiments to determine how many average damps are required to compute nth roots as a
; fixed-point search based upon repeated average damping of y->x/y^(n−1).
;
; Use this to implement a simple procedure for computing nth roots using fixed-point,
; average-damp, and the repeated procedure of Exercise 1.43

; Assume that any arithmetic operations you need are available as primitives.

(defn nth-root
  [x n damps]
  (b13/fixed-point
    ((ex-1-43/repeated b13/average-damp damps)
     (fn [y] (/ x (Math/pow y (dec n)))))
    1.0))

; The number of repetitions of the average moisture content
; can be calculated using the semi- and logarithmic basis 2
(defn damp-number
  [n]
  (int (Math/floor (/ (Math/log n) (Math/log 2)))))

(defn nth-root-auto-damps
  [x n]
  (nth-root x n (damp-number n)))
