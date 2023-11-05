(ns sicp.chapter-2.part-2.ex-2-38-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-38 :refer [fold-left fold-right]]))

(deftest fold-right-test
  (is (= 3/2 (fold-right / 1 (list 1 2 3))))
  (is (= '(1 (2 (3 nil))) (fold-right list nil (list 1 2 3)))))

(deftest fold-left-test
  (is (= 1/6 (fold-left / 1 (list 1 2 3))))
  (is (= '(((nil 1) 2) 3) (fold-left list nil (list 1 2 3)))))

(deftest answer-test
  ; op should satisfy two arguments of one var type without stric order (+, *, etc)
  (is (= (fold-right + 1 (list 1 2 3)) (fold-left + 1 (list 1 2 3))))
  (is (= (fold-right * 1 (list 1 2 3)) (fold-left * 1 (list 1 2 3)))))
