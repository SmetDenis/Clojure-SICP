(ns sicp.chapter-2.part-2.ex-2-17-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-17 :refer [last-pair]]))

(deftest last-pair-test
  (is (= nil (last-pair '())))
  (is (= '(1) (last-pair '(1))))
  (is (= '(34) (last-pair (list 23 72 149 34)))))
