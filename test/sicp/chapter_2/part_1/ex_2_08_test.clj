(ns sicp.chapter-2.part-1.ex-2-08-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.ex-2-07 :refer [make-interval]]
    [sicp.chapter-2.part-1.ex-2-08 :refer [sub-interval]]))

(def interval-1 (make-interval 1 1.1))
(def interval-2 (make-interval 5 5.5))

(deftest sub-interval-test
  (is (= [4 4.4] (sub-interval interval-2 interval-1))))
