(ns sicp.chapter-2.part-2.ex-2-19-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-19 :refer [cc]]))

(deftest cc-test
  (is (= 1 (cc 100 '(1))))
  (is (= 21 (cc 100 '(5 1))))
  (is (= 292 (cc 100 '(50 25 10 5 1))))
  (is (= 4563 (cc 100 '(100 50 20 10 5 2 1 0.5)))))
