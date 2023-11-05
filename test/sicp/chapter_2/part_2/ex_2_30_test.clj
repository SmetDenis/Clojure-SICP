(ns sicp.chapter-2.part-2.ex-2-30-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-30 :refer [square-tree square-tree-map]]))

(deftest square-tree-test
  (is (= '(1 (4 (9 16) 25) (36 49)) (square-tree '(1 (2 (3 4) 5) (6 7))))))

(deftest square-tree-map-test
  (is (= '(1 (4 (9 16) 25) (36 49)) (square-tree-map '(1 (2 (3 4) 5) (6 7))))))
