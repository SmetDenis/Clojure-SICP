(ns sicp.chapter-2.part-2.ex-2-32-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-32 :refer [subsets]]))

(deftest subsets-test
  (is (= '(() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3)) (subsets '(1 2 3)))))
