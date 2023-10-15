(ns sicp.chapter-1.ex-1-8-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.ex-1-8 :refer [cube-root-iter]]))

(deftest cube-root-iter-test
  ; 1.0
  ; 72.66666666666667
  ; 48.458079660335365
  ; 32.336048413257366
  ; 21.626224274645978
  ; 14.571429800581024
  ; 10.053386822532781
  ; 7.414631307227974
  ; 6.252731892895681
  ; 6.0100776484658
  (is (= 6.000016888672678 (cube-root-iter 1.0 (* 6 6 6)))))
