(ns sicp.chapter-2.part-2.ex-2-52-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-52 :refer [corner-split]]))

; I don't know to test it properly...

(deftest corner-split-test
  (is (= true (fn? (corner-split (fn [_] ()) 5)))))
