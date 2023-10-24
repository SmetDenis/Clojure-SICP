(ns sicp.chapter-2.part-1.ex-2-09-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.book-2-1 :as b21]
            [sicp.chapter-2.part-1.ex-2-07 :as ex-2-07]
            [sicp.chapter-2.part-1.ex-2-08 :as ex-2-08]
            [sicp.chapter-2.part-1.ex-2-09 :refer [radius]]))

(def interval-1 (ex-2-07/make-interval 20 30))
(def interval-2 (ex-2-07/make-interval 60 100))

(deftest radius-test
  (is (= 5 (radius interval-1)))
  (is (= 20 (radius interval-2))))

(deftest radius-sum-test
  (is (= (+ (radius interval-1) (radius interval-2))
         (radius (b21/add-interval interval-1 interval-2))))) ; equal

(deftest radius-sub-test
  (is (= (- (radius interval-2) (radius interval-1))
         (radius (ex-2-08/sub-interval interval-2 interval-1))))) ; equal

(deftest radius-mul-test
  (is (not (= (/ (radius interval-1) (radius interval-2))
              (radius (b21/mul-interval interval-1 interval-2)))))) ; not equal

(deftest radius-div-test
  (is (not (= (* (radius interval-2) (radius interval-1))
              (radius (b21/div-interval interval-2 interval-1)))))) ; not equal
