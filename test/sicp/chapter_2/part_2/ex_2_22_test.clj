(ns sicp.chapter-2.part-2.ex-2-22-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-22 :refer [square-list-1]]))

(deftest square-list-1-test
  (is (= '(16 9 4 1) (square-list-1 (list 1 2 3 4)))))
