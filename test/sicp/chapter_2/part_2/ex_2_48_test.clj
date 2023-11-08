(ns sicp.chapter-2.part-2.ex-2-48-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-48 :refer [end-segment make-segment start-segment]]))

(def seg-1 (make-segment 1 2))
(def seg-2 (make-segment 3 4))

(deftest make-vect-test
  (is (= '(1 2) (make-segment 1 2))))

(deftest start-segment-test
  (is (= 1 (start-segment seg-1)))
  (is (= 3 (start-segment seg-2))))

(deftest end-segment-test
  (is (= 2 (end-segment seg-1)))
  (is (= 4 (end-segment seg-2))))
