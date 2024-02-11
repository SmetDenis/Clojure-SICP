(ns sicp.chapter-1.part-2.ex-1-15-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-15 :refer [sine]]))

(deftest sine-test
  (is (= -0.39980345741334 (sine 12.15))))                  ; 5 times, O(log3(n))
