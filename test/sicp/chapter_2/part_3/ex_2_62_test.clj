(ns sicp.chapter-2.part-3.ex-2-62-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.ex-2-62 :refer [union-set-sorted]]))

(deftest union-set-sorted-test
  (is (= '() (union-set-sorted '() '())))
  (is (= '(1) (union-set-sorted '(1) '())))
  (is (= '(1) (union-set-sorted '() '(1))))
  (is (= '(1) (union-set-sorted '(1) '(1))))
  (is (= '(1 2) (union-set-sorted '(1) '(2))))
  (is (= '(1 2) (union-set-sorted '(1 2) '(2))))
  (is (= '(1 2 3) (union-set-sorted '(1 2) '(3))))
  (is (= '(1 2 3 4 5) (union-set-sorted '(1 2 3) '(3 4 5)))))
