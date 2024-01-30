(ns sicp.chapter-1.part-2.ex-1-23-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-2.ex-1-23 :refer [find-divisor next-odd prime? smallest-divisor]]))

(deftest next-odd-test
  (is (= 3 (next-odd 1)))
  (is (= 3 (next-odd 2)))
  (is (= 5 (next-odd 3)))
  (is (= 6 (next-odd 4)))
  (is (= 7 (next-odd 5))))

(deftest smallest-divisor-test
  (is (= 2 (smallest-divisor 2)))
  (is (= 3 (smallest-divisor 3)))
  (is (= 2 (smallest-divisor 6)))
  (is (= 2 (smallest-divisor 30)))
  (is (= 11 (smallest-divisor 11)))
  (is (= 31 (smallest-divisor 31))))

(deftest find-divisor-test
  (is (= 2 (find-divisor 2 4)))
  (is (= 5 (find-divisor 5 35)))
  (is (= 7 (find-divisor 7 35)))
  (is (= 100 (find-divisor 100 100)))
  (is (= 10 (find-divisor 10 100))))

(deftest prime?-test
  ; Prime
  (is (= true (prime? 1)))
  (is (= true (prime? 2)))
  (is (= true (prime? 3)))
  (is (= true (prime? 5)))
  (is (= true (prime? 7)))
  (is (= true (prime? 11)))
  (is (= true (prime? 23)))
  ; Not prime
  (is (= false (prime? 4)))
  (is (= false (prime? 6)))
  (is (= false (prime? 8)))
  (is (= false (prime? 20))))
