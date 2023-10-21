(ns sicp.misc-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.misc :as m]))

(deftest square-test
  (is (= 4 (m/square 2)))
  (is (= 9 (m/square 3))))

(deftest cube-test
  (is (= 8 (m/cube 2)))
  (is (= 27 (m/cube 3)))
  (is (= 64 (m/cube 4)))
  (is (= 125 (m/cube 5))))

(deftest close-enough?-test
  (is (= false (m/close-enough? 1 2)))
  (is (= true (m/close-enough? 1 1)))
  (is (= true (m/close-enough? 1 1.00001)))
  (is (= true (m/close-enough? 1 1.0001)))
  (is (= true (m/close-enough? 1 1.001)))
  (is (= false (m/close-enough? 1 1.01)))

  (is (= false (m/close-enough? 1 2 1)))
  (is (= true (m/close-enough? 1 1 1)))
  (is (= true (m/close-enough? 1 1.00001 1)))
  (is (= true (m/close-enough? 1 1.0001 1)))
  (is (= true (m/close-enough? 1 1.001 1)))
  (is (= true (m/close-enough? 1 1.01 1)))
  (is (= false (m/close-enough? 1 10 1))))

(deftest average-test
  (is (= 11/2 (m/average 1 10)))
  (is (= 5.5 (m/average 1.0 10.0))))

(deftest positive?-test
  (is (= false (m/positive? 0)))
  (is (= true (m/positive? 1)))
  (is (= false (m/positive? -1))))

(deftest negative?-test
  (is (= false (m/negative? 0)))
  (is (= false (m/negative? 1)))
  (is (= true (m/negative? -1))))
