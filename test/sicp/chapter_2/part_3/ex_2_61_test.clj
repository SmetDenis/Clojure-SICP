(ns sicp.chapter-2.part-3.ex-2-61-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.ex-2-61 :refer [adjoin-set-sorted]]))

(deftest adjoin-set-sorted-test
  (is (= '(1) (adjoin-set-sorted 1 '())))
  (is (= '(1 2 3) (adjoin-set-sorted 1 '(2 3))))
  (is (= '(1 2 3) (adjoin-set-sorted 1 '(1 2 3))))
  (is (= '(4 1 2 3) (adjoin-set-sorted 4 '(1 2 3)))))
