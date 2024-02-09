(ns sicp.chapter-2.part-1.book-2-1-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.book-2-1 :as b21]))

(comment "2 Building Abstractions with Data ------------------------------------------------------")

(deftest linear-combination-test
  (is (= 11 (b21/linear-combination 1 2 3 4))))

(comment "2.1.1 Example: Arithmetic Operations for Rational Numbers ------------------------------")

(def one-half (b21/make-rat 1 2))
(def one-third (b21/make-rat 1 3))
(def no-optimal (b21/make-rat 6 24))

(deftest make-rat-test
  (is (= [1 2] (b21/make-rat 1 2)))
  (is (= [1 3] (b21/make-rat 1 3))))

(deftest numer-test
  (is (= 1 (b21/numer one-half)))
  (is (= 1 (b21/numer one-third)))
  (is (= 1 (b21/numer no-optimal))))

(deftest denom-test
  (is (= 2 (b21/denom one-half)))
  (is (= 3 (b21/denom one-third)))
  (is (= 4 (b21/denom no-optimal))))

(deftest add-rat-test
  (is (= [5 6] (b21/add-rat one-half one-third)))
  (is (= [2 3] (b21/add-rat one-third one-third))))

(deftest sub-rat-test
  (is (= [1 6] (b21/sub-rat one-half one-third)))
  (is (= [0 1] (b21/sub-rat one-half one-half))))

(deftest mul-rat-test
  (is (= [1 6] (b21/mul-rat one-half one-third))))

(deftest div-rat-test
  (is (= [3 2] (b21/div-rat one-half one-third))))

(deftest equal-rat?-test
  (is (= false (b21/equal-rat? one-half one-third)))
  (is (= true (b21/equal-rat? one-half one-half))))

(deftest print-rat-test
  (is (= "1/2" (b21/print-rat one-half)))
  (is (= "1/3" (b21/print-rat one-third))))

(comment "2.1.2 Abstraction Barriers -------------------------------------------------------------")

(def one-half-alt (b21/make-rat-alt 1 2))
(def one-third-alt (b21/make-rat-alt 1 3))
(def no-optimal-alt (b21/make-rat-alt 6 24))

(deftest make-rat-alt-test
  (is (= [1 2] (b21/make-rat-alt 1 2)))
  (is (= [1 3] (b21/make-rat-alt 1 3)))
  (is (= [6 24] (b21/make-rat-alt 6 24))))

(deftest numer-alt-test
  (is (= 1 (b21/numer-alt one-half-alt)))
  (is (= 1 (b21/numer-alt one-third-alt)))
  (is (= 1 (b21/numer-alt no-optimal-alt))))

(deftest denom-alt-test
  (is (= 2 (b21/denom-alt one-half)))
  (is (= 3 (b21/denom-alt one-third-alt)))
  (is (= 4 (b21/denom-alt no-optimal-alt))))

(comment "2.1.3 What Is Meant by Data? -----------------------------------------------------------")

(deftest pair-alt-test
  (is (= 1 (b21/car-alt (b21/pair-alt 1 2))))
  (is (= 2 (b21/cdr-alt (b21/pair-alt 1 2)))))
