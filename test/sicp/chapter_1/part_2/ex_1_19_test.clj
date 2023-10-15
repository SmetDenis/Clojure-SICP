(ns sicp.chapter-1.part_2.ex-1-19-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.part_2.ex-1-19 :refer [fib fib-v2]]))

(deftest fib-test
  (is (= 1 (fib 1)))
  (is (= 2 (fib 50))))                                      ; Invalid result! It's expexted

(deftest fib-v2-test
  (is (= 1 (fib-v2 1)))
  (is (= 12586269025 (fib-v2 50))))
