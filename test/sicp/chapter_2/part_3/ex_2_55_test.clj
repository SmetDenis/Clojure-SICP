(ns sicp.chapter-2.part-3.ex-2-55-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.ex-2-55 :refer [print-test]]))

(deftest print-test-test
  (is (= 'quote (print-test))))
