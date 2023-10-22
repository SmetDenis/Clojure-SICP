(ns sicp.chapter-2.part-1.ex-2-06-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-06 :as ex-2-06]))

(def f (fn [x] x))

(deftest zero-test
  (is (= 0 ((ex-2-06/zero f) 0))))

(deftest one-test
  (is (= 0 ((ex-2-06/one f) 0))))

(deftest two-test
  (is (= 0 ((ex-2-06/two f) 0))))

(deftest add-1-test
  (is (= 0 (((ex-2-06/add-1 ex-2-06/one) f) 0))))

(deftest add-test
  (is (= ((ex-2-06/two f) 0)
         (((ex-2-06/add ex-2-06/zero ex-2-06/one) f) 0))))
