(ns sicp.chapter-2.part-2.ex-2-21-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-21 :refer [square-list-1 square-list-2]]))

(deftest square-list-2-test
  (is (= '(1 4 9 16) (square-list-1 '(1 2 3 4))))
  (is (= '(1 4 9 16) (square-list-2 '(1 2 3 4)))))
