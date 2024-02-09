(ns sicp.chapter-2.part-1.ex-2-12
  (:require
    [sicp.chapter-2.part-1.ex-2-11 :as ex-2-11]
    [sicp.misc :as m]))

; Exercise 2.12
; Define a constructor make-center-percent that takes a center and a percentage tolerance
; and produces the desired interval.
; You must also define a selector percent that produces the percentage tolerance
; for a given interval.
; The center selector is the same as the one shown above.

(defn make-center-percent
  [average percent]
  (let [diff (* average (/ percent 100.0))
        low  (- average diff)
        high (+ average diff)]
    (m/make-interval low high)))

(defn percent
  [interval]
  (* 100.0 (/ (- (m/upper-bound interval) (ex-2-11/center interval))
              (ex-2-11/center interval))))
