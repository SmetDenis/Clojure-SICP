(ns sicp.chapter-2.part-2.ex-2-18-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-18 :refer [list-reverse]]))

(deftest list-reverse-test
  (is (= '() (list-reverse nil)))
  (is (= '() (list-reverse '())))
  (is (= '(1) (list-reverse '(1))))
  (is (= '(2 1) (list-reverse '(1 2))))
  (is (= '(3 2 1) (list-reverse '(1 2 3))))
  (is (= (list 25 16 9 4 1) (list-reverse (list 1 4 9 16 25)))))
