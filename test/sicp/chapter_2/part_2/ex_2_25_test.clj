(ns sicp.chapter-2.part-2.ex-2-25-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.misc :refer [car cdr]]))

(deftest list-test
  (is (= 7
         (car (cdr (car (cdr (cdr '(1 3 (5 7) 9))))))))
  (is (= 7
         (car (car '((7))))))
  (is (= 7
         (car (cdr (car (cdr (car (cdr (car (cdr (car (cdr (car (cdr
                                                                  '(1 (2 (3 (4 (5 (6 7)))))))))))))))))))))
