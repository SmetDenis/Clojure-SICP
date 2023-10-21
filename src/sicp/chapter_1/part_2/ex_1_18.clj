(ns sicp.chapter-1.part_2.ex-1-18
  (:require [sicp.chapter-1.part_2.ex-1-16 :refer [expt]]))

; Exercise 1.18
; Using the results of Exercise 1.16 and Exercise 1.17, devise a procedure that generates an iterative
; process for multiplying two integers in terms of adding, doubling, and halving and uses a logarithmic number of steps.

(defn fast-mult-v2
  [a b product counter]
  (cond (= a 0) product
        (= (mod a 2) 1) (fast-mult-v2 (/ a 2)
                                      b
                                      (+ product (* (expt 2 counter) b))
                                      (+ counter 1))
        :else (fast-mult-v2 (/ a 2)
                            b
                            product
                            (+ counter 1))))

(defn mult [a b]
  (fast-mult-v2 a b 0 0))
