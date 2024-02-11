(ns sicp.chapter-2.part-2.ex-2-49-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-49 :refer [diamond-painter outline-painter x-painter]]))

; I don't know to test it properly...

(deftest outline-painter-test
  (is (= true (fn? (outline-painter)))))

(deftest x-painter-test
  (is (= true (fn? (x-painter)))))

(deftest diamond-painter-test
  (is (= true (fn? (diamond-painter)))))
