(ns sicp.chapter-1.part-2.ex-1-22-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-22 :refer [find-primes]]))

(deftest find-primes-test
  (is (= 5 (find-primes 1 5 false))))                       ; Change arguments and see the output
