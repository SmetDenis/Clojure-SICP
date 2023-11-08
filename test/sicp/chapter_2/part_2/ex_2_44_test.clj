(ns sicp.chapter-2.part-2.ex-2-44-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-44 :refer [up-split]]))

(deftest up-split-test
  (is (= nil (up-split 1 1))))                              ; I can't cover it with unit tests. :(
