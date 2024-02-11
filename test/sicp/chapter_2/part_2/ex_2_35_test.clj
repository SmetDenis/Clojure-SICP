(ns sicp.chapter-2.part-2.ex-2-35-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-35 :refer [count-leaves]]))

(def tree (cons (list 1 2) (list 3 4)))                     ; ((1 2) 3 4)

(deftest count-leaves-test
  (is (= 4 (count-leaves tree)))
  (is (= 2 (count-leaves '(1 2)))))
