(ns sicp.chapter-1.part_1.ex-1-4-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part_1.ex-1-4 :refer [a-plus-abs-b]]))

(deftest a-plus-abs-b-test
  (is (= 2 (a-plus-abs-b 1 1)))
  (is (= 2 (a-plus-abs-b 1 -1)))
  (is (= 0 (a-plus-abs-b -1 1)))
  (is (= 0 (a-plus-abs-b -1 -1))))
