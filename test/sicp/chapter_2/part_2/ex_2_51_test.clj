(ns sicp.chapter-2.part-2.ex-2-51-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-51 :refer [below below-v2]]))

; I don't know to test it properly...

(deftest below-test
  (is (= true (fn? (below (fn [_] ()) (fn [_] ()))))))

(deftest below-v2-test
  (is (= true (fn? (below-v2 (fn [_] ()) (fn [_] ()))))))
