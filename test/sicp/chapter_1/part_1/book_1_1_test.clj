(ns sicp.chapter-1.part-1.book-1-1-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-1.book-1-1 :as b11]))

(comment "1.1.4 Compound Procedures --------------------------------------------------------------")

(deftest square-test
  (is (= 4 (b11/square 2)))
  (is (= 16 (b11/square 4))))

(comment "1.1.5 The Substitution Model for Procedure Application ---------------------------------")

(deftest sum-of-squares-test
  (is (= 25 (b11/sum-of-squares 3 4)))
  (is (= 41 (b11/sum-of-squares 4 5))))

(comment "1.1.6 Conditional Expressions and Predicates -------------------------------------------")

(deftest abs-1-test
  (is (= 1 (b11/abs-1 1)))
  (is (zero? (b11/abs-1 0)))
  (is (= 1 (b11/abs-1 -1))))

(deftest abs-2-test
  (is (= 1 (b11/abs-2 1)))
  (is (zero? (b11/abs-2 0)))
  (is (= 1 (b11/abs-2 -1))))

(deftest abs-3-test
  (is (= 1 (b11/abs-3 1)))
  (is (zero? (b11/abs-3 0)))
  (is (= 1 (b11/abs-3 -1))))

(deftest >=-1-test
  (is (false? (b11/>=-1 1 2)))
  (is (true? (b11/>=-1 1 1)))
  (is (true? (b11/>=-1 2 1))))

(deftest >=-2-test
  (is (false? (b11/>=-2 1 2)))
  (is (true? (b11/>=-2 1 1)))
  (is (true? (b11/>=-2 2 1))))

(comment "1.1.7 Example: Square Roots by Newton’s Method -----------------------------------------")

(deftest sqrt-test
  (is (= 3.00009155413138 (b11/sqrt 9)))
  (is (= 11.704699917758145 (b11/sqrt (+ 100 37))))
  (is (= 1.7739279023207892 (b11/sqrt (+ (b11/sqrt 2) (b11/sqrt 3)))))
  (is (= 1000.000369924366 (b11/square (b11/sqrt 1000)))))

(comment "1.1.8 Procedures as Black-Box Abstractions ---------------------------------------------")

(deftest square-alt-test
  (is (= 1.0 (b11/square-alt 1)))
  (is (= 100.00000000000004 (b11/square-alt 100)))
  (is (= 10000.00000000001 (b11/square-alt 10000))))

(deftest sqrt-alt-test
  (is (= 1.0 (b11/sqrt-alt 1)))
  (is (= 2.0000000929222947 (b11/sqrt-alt 4)))
  (is (= 3.162277665175675 (b11/sqrt-alt 10))))
