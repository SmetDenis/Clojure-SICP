(ns sicp.chapter-1.part_2.ex_1_15-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.part_2.ex_1_15 :refer [sine]]))

(deftest sine-test
  (is (= -0.39980345741334 (sine 12.15)))                   ; 5 times, O(log3(n))
)
