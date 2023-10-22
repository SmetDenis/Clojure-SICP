(ns sicp.chapter-2.part-1.book-2-1-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.book-2-1 :as book]))

(deftest linear-combination-test
  (is (= 11 (book/linear-combination 1 2 3 4))))

(def one-half (book/make-rat 1 2))
(def one-third (book/make-rat 1 3))

(deftest make-rat-test
  (is (= [1 2] (book/make-rat 1 2)))
  (is (= [1 3] (book/make-rat 1 3))))

(deftest add-rat-test
  (is (= [5 6] (book/add-rat one-half one-third)))
  (is (= [2 3] (book/add-rat one-third one-third))))

(deftest sub-rat-test
  (is (= [1 6] (book/sub-rat one-half one-third)))
  (is (= [0 1] (book/sub-rat one-half one-half))))

(deftest mul-rat-test
  (is (= [1 6] (book/mul-rat one-half one-third))))

(deftest div-rat-test
  (is (= [3 2] (book/div-rat one-half one-third))))

(deftest equal-rat?-test
  (is (= false (book/equal-rat? one-half one-third)))
  (is (= true (book/equal-rat? one-half one-half))))

(deftest print-rat-test
  (is (= "1/2" (book/print-rat one-half)))
  (is (= "1/3" (book/print-rat one-third))))
