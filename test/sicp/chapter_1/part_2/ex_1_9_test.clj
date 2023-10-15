(ns sicp.chapter-1.part_2.ex-1-9-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.part_2.ex-1-9 :refer [plus plus-v2]]))

(deftest plus-test
  (is (= 3 (plus 1 2))))

(deftest plus-v2-test
  (is (= 3 (plus-v2 1 2))))
