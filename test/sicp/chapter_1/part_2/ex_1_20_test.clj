(ns sicp.chapter-1.part-2.ex-1-20-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-20 :refer [gcd]]))

(deftest gcd-test
  (is (= 2 (gcd 206 40))))                                  ; 4 times
