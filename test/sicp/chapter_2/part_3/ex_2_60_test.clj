(ns sicp.chapter-2.part-3.ex-2-60-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-60 :refer [adjoin-set
                                                   element-of-set?
                                                   intersection-set
                                                   union-set]]))

(deftest element-of-set?-test
  (is (= false (element-of-set? 1 '())))
  (is (= true (element-of-set? 1 '(1))))
  (is (= true (element-of-set? 1 '(1 2)))))

(deftest adjoin-set-test
  (is (= '(1 2 3) (adjoin-set 1 '(2 3))))
  (is (= '(1 1 2 3) (adjoin-set 1 '(1 2 3)))))

(deftest intersection-set-test
  (is (= '() (intersection-set '() '())))
  (is (= '() (intersection-set '(1 2) '())))
  (is (= '() (intersection-set '() '(1 2))))
  (is (= '(1) (intersection-set '(1) '(1))))
  (is (= '(1) (intersection-set '(1 2) '(1))))
  (is (= '(1) (intersection-set '(1) '(1 2)))))

(deftest union-set-test
  (is (= '(1 2 3 6 1 2 3 4 5) (union-set '(1 2 3 6) '(1 2 3 4 5)))))
