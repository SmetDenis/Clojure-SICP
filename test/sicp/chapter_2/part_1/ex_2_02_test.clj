(ns sicp.chapter-2.part-1.ex-2-02-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.ex-2-02 :as ex-2-02]))

(def point-1 (ex-2-02/make-point 1 2))
(def point-2 (ex-2-02/make-point 3 4))
(def point-mid (ex-2-02/make-point 2 3))
(def segment (ex-2-02/make-segment point-1 point-2))

(deftest make-point-test
  (is (= [1 2] (ex-2-02/make-point 1 2))))

(deftest x-point-test
  (is (= 1 (ex-2-02/x-point point-1))))

(deftest y-point-test
  (is (= 2 (ex-2-02/y-point point-1))))

(deftest print-point-test
  (is (= "(1,2)" (ex-2-02/print-point point-1)))
  (is (= "(3,4)" (ex-2-02/print-point point-2)))
  (is (= "(2,3)" (ex-2-02/print-point point-mid))))

(deftest make-segment-test
  (is (= [point-1 point-2] (ex-2-02/make-segment point-1 point-2))))

(deftest start-segment-test
  (is (= point-1 (ex-2-02/start-segment segment))))

(deftest end-segment-test
  (is (= point-2 (ex-2-02/end-segment segment))))

(deftest midpoint-segment-test
  (is (= point-mid (ex-2-02/midpoint-segment segment))))
