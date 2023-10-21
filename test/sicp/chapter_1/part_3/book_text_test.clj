(ns sicp.chapter-1.part-3.book-text-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.book-text :refer [integral
                                                     pi-sum
                                                     pi-sum-2
                                                     sum-cubes
                                                     sum-cubes-2
                                                     sum-integers
                                                     sum-integers-2
                                                     sum-terms]]
            [sicp.misc :refer [cube]]))

(deftest sum-integers-test
  (is (= 0 (sum-integers 0 0)))
  (is (= 1 (sum-integers 1 1)))
  (is (= 3 (sum-integers 1 2)))
  (is (= 6 (sum-integers 1 3)))
  (is (= 10 (sum-integers 1 4)))
  (is (= 15 (sum-integers 1 5))))

(deftest sum-cubes-test
  (is (= 0 (sum-cubes 0 0)))
  (is (= 1 (sum-cubes 1 1)))
  (is (= 9 (sum-cubes 1 2)))
  (is (= 36 (sum-cubes 1 3)))
  (is (= 100 (sum-cubes 1 4)))
  (is (= 225 (sum-cubes 1 5)))
  (is (= 441 (sum-cubes 1 6)))
  (is (= 784 (sum-cubes 1 7)))
  (is (= 1296 (sum-cubes 1 8)))
  (is (= 2025 (sum-cubes 1 9)))
  (is (= 3025 (sum-cubes 1 10))))

(deftest pi-sum-test
  (is (= 0.3333333333333333 (pi-sum 1 1)))
  (is (= 0.125 (pi-sum 2 2)))
  (is (= 0.372005772005772 (pi-sum 1 10)))
  (is (= 3.139592655589783 (* 8 (pi-sum 1 1000)))))

(deftest sum-terms-test
  (is (= 3025 (sum-terms cube 1 inc 10))))

(deftest sum-integers-2-test
  (is (= 15 (sum-integers-2 1 5)))
  (is (= 55 (sum-integers-2 1 10))))

(deftest sum-cubes-2-test
  (is (= 2025 (sum-cubes-2 1 9)))
  (is (= 3025 (sum-cubes-2 1 10))))

(deftest pi-sum-2-test
  (is (= 0.3333333333333333 (pi-sum-2 1 1)))
  (is (= 0.125 (pi-sum-2 2 2)))
  (is (= 0.372005772005772 (pi-sum-2 1 10)))
  (is (= 3.139592655589783 (* 8 (pi-sum-2 1 1000)))))

(deftest integral-test
  (is (= 0.24998750000000042 (integral cube 0 1 0.01)))
  (is (= 0.249999875000001 (integral cube 0 1 0.001))))
