(ns sicp.chapter-1.part-2.ex-1-26-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-26 :refer [expmod]]))

(deftest expmod-test
  (is (= 1 (expmod 2 0 3)))
  (is (= 1 (expmod 2 4 3)))
  (is (= 25 (expmod 5 10 40)))
  (is (= 0 (expmod 10 5 40))))
