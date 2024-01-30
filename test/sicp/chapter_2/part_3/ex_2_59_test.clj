(ns sicp.chapter-2.part-3.ex-2-59-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-59 :refer [union-set]]))

(deftest union-set-test
  (is (= '() (union-set '() '())))
  (is (= '(1) (union-set '(1) '())))
  (is (= '(1) (union-set '() '(1))))
  (is (= '(1) (union-set '(1) '(1))))
  (is (= '(1 2) (union-set '(1) '(2))))
  (is (= '(1 2) (union-set '(1 2) '(2))))
  (is (= '(1 2 3) (union-set '(1 2) '(3))))
  (is (= '(1 2 3 4 5) (union-set '(1 2 3) '(3 4 5)))))
