(ns sicp.chapter-1.part-2.ex-1-25-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-25 :refer [expmod expmod-alyssa fast-expt]]))

(deftest fast-expt-test
  (is (= 1 (fast-expt 2 0)))
  (is (= 16 (fast-expt 2 4)))
  (is (= 3125 (fast-expt 5 5))))

(deftest expmod-test
  (is (= 1 (expmod 2 0 3)))
  (is (= 16 (expmod 123 44 55))))

(deftest expmod-alyssa-test
  (is (= 1 (expmod-alyssa 2 0 3))))

; (is (= 3 (expmod-alyssa 123 44 55))) ;  It makes too many iterations => time & memory consuming
