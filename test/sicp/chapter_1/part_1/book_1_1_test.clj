(ns sicp.chapter-1.part-1.book-1-1-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-1.book-1-1 :as book]))

(deftest square-test
  (is (= 4 (book/square 2)))
  (is (= 16 (book/square 4))))

(deftest sum-of-squares-test
  (is (= 25 (book/sum-of-squares 3 4)))
  (is (= 41 (book/sum-of-squares 4 5))))

(deftest abs-1-test
  (is (= 1 (book/abs-1 1)))
  (is (= 0 (book/abs-1 0)))
  (is (= 1 (book/abs-1 -1))))

(deftest abs-2-test
  (is (= 1 (book/abs-2 1)))
  (is (= 0 (book/abs-2 0)))
  (is (= 1 (book/abs-2 -1))))

(deftest abs-3-test
  (is (= 1 (book/abs-3 1)))
  (is (= 0 (book/abs-3 0)))
  (is (= 1 (book/abs-3 -1))))

(deftest >=-1-test
  (is (= false (book/>=-1 1 2)))
  (is (= true (book/>=-1 1 1)))
  (is (= true (book/>=-1 2 1))))

(deftest >=-2-test
  (is (= false (book/>=-2 1 2)))
  (is (= true (book/>=-2 1 1)))
  (is (= true (book/>=-2 2 1))))

(deftest square-alt-test
  (is (= 1.0 (book/square-alt 1)))
  (is (= 100.00000000000004 (book/square-alt 100)))
  (is (= 10000.00000000001 (book/square-alt 10000))))

(deftest sqrt-alt-test
  (is (= 1.0 (book/sqrt-alt 1)))
  (is (= 2.0000000929222947 (book/sqrt-alt 4)))
  (is (= 3.162277665175675 (book/sqrt-alt 10))))

