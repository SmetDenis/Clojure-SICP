(ns sicp.chapter-2.part-1.book-2-1-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.book-2-1 :as b21]))

(deftest linear-combination-test
  (is (= 11 (b21/linear-combination 1 2 3 4))))

(def one-half (b21/make-rat 1 2))
(def one-third (b21/make-rat 1 3))

(deftest make-rat-test
  (is (= [1 2] (b21/make-rat 1 2)))
  (is (= [1 3] (b21/make-rat 1 3))))

(deftest add-rat-test
  (is (= [5 6] (b21/add-rat one-half one-third)))
  (is (= [2 3] (b21/add-rat one-third one-third))))

(deftest sub-rat-test
  (is (= [1 6] (b21/sub-rat one-half one-third)))
  (is (= [0 1] (b21/sub-rat one-half one-half))))

(deftest mul-rat-test
  (is (= [1 6] (b21/mul-rat one-half one-third))))

(deftest div-rat-test
  (is (= [3 2] (b21/div-rat one-half one-third))))

(deftest equal-rat?-test
  (is (= false (b21/equal-rat? one-half one-third)))
  (is (= true (b21/equal-rat? one-half one-half))))

(deftest print-rat-test
  (is (= "1/2" (b21/print-rat one-half)))
  (is (= "1/3" (b21/print-rat one-third))))
