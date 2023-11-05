(ns sicp.chapter-2.part-2.ex-2-31-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-31 :refer [square-tree tree-map]]
            [sicp.misc :as m]))

(deftest square-tree-test
  (is (= '(1 (4 (9 16) 25) (36 49)) (square-tree '(1 (2 (3 4) 5) (6 7))))))

(deftest tree-map-test
  (is (= '(1 (8 (27 64) 125) (216 343)) (tree-map m/cube '(1 (2 (3 4) 5) (6 7))))))
