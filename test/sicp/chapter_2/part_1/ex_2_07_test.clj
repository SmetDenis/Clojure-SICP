(ns sicp.chapter-2.part-1.ex-2-07-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.book-2-1 :as b21]
    [sicp.chapter-2.part-1.ex-2-07 :refer [lower-bound make-interval upper-bound]]))

(def interval-1 (make-interval 1 2))
(def interval-2 (make-interval 4 5))

(deftest make-interval-test
  (is (= [1 2] (make-interval 1 2))))

(deftest lower-bound-test
  (is (= 1 (lower-bound interval-1))))

(deftest upper-bound-test
  (is (= 2 (upper-bound interval-1))))

(deftest add-interval-test
  (is (= [5 7] (b21/add-interval interval-1 interval-2))))

(deftest div-interval-test
  (is (= [0.2 0.5] (b21/div-interval interval-1 interval-2))))

(deftest mul-interval-test
  (is (= [4 10] (b21/mul-interval interval-1 interval-2))))
