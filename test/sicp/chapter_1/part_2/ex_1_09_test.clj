(ns sicp.chapter-1.part-2.ex-1-09-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-09 :refer [plus plus-v2]]))

(deftest plus-test
  (is (= 3 (plus 1 2)))
  (is (= 2 (plus 0 2))))

(deftest plus-v2-test
  (is (= 3 (plus-v2 1 2)))
  (is (= 2 (plus-v2 0 2))))
