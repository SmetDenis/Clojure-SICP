(ns sicp.chapter-2.part-1.ex-2-06-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.ex-2-06 :as ex-2-06]))

(def f (fn [x] x))
(def placeholder (rand-int 100))                            ; Hackish to execute test cases

(deftest zero-test
  (is (= placeholder ((ex-2-06/zero f) placeholder))))

(deftest one-test
  (is (= placeholder ((ex-2-06/one f) placeholder))))

(deftest two-test
  (is (= placeholder ((ex-2-06/two f) placeholder))))

(deftest add-1-test
  (is (= ((ex-2-06/two f) placeholder)
         (((ex-2-06/add-1 ex-2-06/one) f) placeholder))))

(deftest add-test
  (is (= ((ex-2-06/two f) placeholder)
         (((ex-2-06/add ex-2-06/zero ex-2-06/one) f) placeholder))))
