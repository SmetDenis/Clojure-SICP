(ns sicp.chapter-1.part-1.ex-1-03-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-1.ex-1-03 :refer [sum-larger-numbers-square]]))

(deftest sum-larger-numbers-square-test
  (is (= 2 (sum-larger-numbers-square 1 1 1)))
  (is (= 13 (sum-larger-numbers-square 1 2 3)))
  (is (= 13 (sum-larger-numbers-square 3 2 1)))
  (is (= 18 (sum-larger-numbers-square 3 3 4))))
