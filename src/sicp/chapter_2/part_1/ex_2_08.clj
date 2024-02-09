(ns sicp.chapter-2.part-1.ex-2-08
  (:require
    [sicp.chapter-2.part-1.ex-2-07 :as ex-2-07]))

; Exercise 2.8
; Using reasoning analogous to Alyssa’s, describe how the difference of two intervals may be computed.
; Define a corresponding subtraction procedure, called sub-interval.

(defn sub-interval
  [interval-1 interval-2]
  (ex-2-07/make-interval (- (ex-2-07/lower-bound interval-1)
                            (ex-2-07/lower-bound interval-2))
                         (- (ex-2-07/upper-bound interval-1)
                            (ex-2-07/upper-bound interval-2))))
