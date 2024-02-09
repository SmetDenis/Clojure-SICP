(ns sicp.chapter-1.part-3.ex-1-34-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-3.ex-1-34 :refer [f]]
    [sicp.misc :as m]))

(deftest f-test
  (is (= 4 (f m/square)))
  (is (= 6 (f #(* % (+ % 1))))))
