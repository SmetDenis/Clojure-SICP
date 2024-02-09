(ns sicp.chapter-2.part-1.ex-2-10
  (:require
    [sicp.misc :as m]))

; Exercise 2.10
; Ben Bitdiddle, an expert systems programmer, looks over Alyssa’s shoulder
; and comments that it is not clear what it means to divide by an interval that spans zero.
; Modify Alyssa’s code to check for this condition and to signal an error if it occurs.

(defn div-interval
  [interval-1 interval-2]
  (if (neg? (* (m/lower-bound interval-2) (m/upper-bound interval-2)))
    (m/error "interval-2 is spanning zero")
    (m/mul-interval
      interval-1
      (m/make-interval (/ 1.0 (m/lower-bound interval-2))
                       (/ 1.0 (m/upper-bound interval-2))))))
