(ns sicp.chapter-2.part-2.ex-2-39-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-39 :refer [reverse-left reverse-right]]))

(deftest reverse-right-test
  (is (= '(3 2 1) (reverse-right '(1 2 3)))))

(deftest reverse-left-test
  (is (= '(3 2 1) (reverse-left '(1 2 3)))))
