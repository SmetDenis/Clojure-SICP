(ns sicp.chapter-1.ex-1-22-test
  (:require [clojure.test :refer :all])
  (:require [sicp.chapter-1.ex-1-22 :refer [find-primes]]))

(deftest find-primes-test
  (is (= 5 (find-primes 1 5))))                             ; Change arguments and see the output
