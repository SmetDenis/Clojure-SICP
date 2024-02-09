(ns sicp.chapter-2.part-1.ex-2-09
  (:require
    [sicp.chapter-2.part-1.ex-2-07 :as ex-2-07]))

; Exercise 2.9
; The width of an interval is half of the difference between its upper and lower bounds.
; The width is a measure of the uncertainty of the number specified by the interval.
; For some arithmetic operations the width of the result of combining two intervals
; is a function only of the widths of the argument intervals, whereas for others the
; width of the combination is not a function of the widths of the argument intervals.
; Show that the width of the sum (or difference) of two intervals is a function
; only of the widths of the intervals being added (or subtracted).
; Give examples to show that this is not true for multiplication or division.

(defn radius
  [interval]
  (/ (- (ex-2-07/upper-bound interval)
        (ex-2-07/lower-bound interval)) 2))
