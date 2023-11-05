(ns sicp.chapter-2.part-2.ex-2-36-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-36 :refer [accumulate-n]]))

(deftest accumulate-n-test
  (is (= '(22 26 30) (accumulate-n + 0 '((1 2 3) (4 5 6) (7 8 9) (10 11 12))))))
