(ns sicp.chapter-1.part-2.ex-1-26-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-26 :refer [expmod]]))

(deftest expmod-test
  (is (= 1 (expmod 2 0 3))))
