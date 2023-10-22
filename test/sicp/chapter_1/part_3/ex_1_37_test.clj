(ns sicp.chapter-1.part-3.ex-1-37-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-37 :refer [cont-frac cont-frac-iter]]
            [sicp.misc :as m]))

; See https://en.wikipedia.org/wiki/Golden_ratio
(def invert-psi (/ 1 1.618033988749894))                    ; 0.6180339887498948
(def precision 0.0001)                                      ; Accurate to 4 decimal places

; 1. Recursive process -----------------------------------------------------------------------------
; Moving from 1 => k
(defn frac-wrap [k precision]
  (m/close-enough? invert-psi
                   (cont-frac (fn [_] 1.0) (fn [_] 1.0) k)
                   precision))

(deftest cont-frac-test
  (is (= false (frac-wrap 1 precision)))
  (is (= false (frac-wrap 2 precision)))
  (is (= false (frac-wrap 3 precision)))
  (is (= false (frac-wrap 4 precision)))
  (is (= false (frac-wrap 5 precision)))
  (is (= false (frac-wrap 6 precision)))
  (is (= false (frac-wrap 7 precision)))
  (is (= false (frac-wrap 8 precision)))
  (is (= true (frac-wrap 9 precision))))                    ; Iterations = 9

; 2. Iterative process -----------------------------------------------------------------------------
; Moving from k => 1. So wie have +1 iteration
(defn frac-iter-wrap [k precision]
  (m/close-enough? invert-psi
                   (cont-frac-iter (fn [_] 1.0) (fn [_] 1.0) k)
                   precision))

(deftest cont-frac-iter-test
  (is (= false (frac-iter-wrap 1 precision)))
  (is (= false (frac-iter-wrap 2 precision)))
  (is (= false (frac-iter-wrap 3 precision)))
  (is (= false (frac-iter-wrap 4 precision)))
  (is (= false (frac-iter-wrap 5 precision)))
  (is (= false (frac-iter-wrap 6 precision)))
  (is (= false (frac-iter-wrap 7 precision)))
  (is (= false (frac-iter-wrap 8 precision)))
  (is (= false (frac-iter-wrap 9 precision)))
  (is (= true (frac-iter-wrap 10 precision))))              ;  iterations = 10
