(ns sicp.chapter-2.part-2.ex-2-50-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-50 :refer [flip-horiz rotate-180-cc rotate-270-cc]]))

; I don't know to test it properly...

(deftest flip-horiz-test
  (is (= true (fn? (flip-horiz (fn [_] ()))))))

(deftest rotate-180-cc-test
  (is (= true (fn? (rotate-180-cc (fn [_] ()))))))

(deftest rotate-270-cc-test
  (is (= true (fn? (rotate-270-cc (fn [_] ()))))))
