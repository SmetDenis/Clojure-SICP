(ns sicp.chapter-2.part-2.ex-2-37-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-37 :refer [dot-product matrix-*-matrix matrix-*-vector transpose]]))

(deftest dot-product-test
  (is (= (+ 1 4) (dot-product '(1 2) '(1 2))))
  (is (= (+ 1 4 9) (dot-product '(1 2 3) '(1 2 3))))
  (is (= (+ 4 6 6 4) (dot-product '(1 2 3 4) '(4 3 2 1)))))

(deftest matrix-*-vector-test
  (is (= '(50 122) (matrix-*-vector '((1 2 3) (4 5 6)) '(7 8 9)))))

(deftest transpose-test
  (is (= '((1 4 7)
           (2 5 8)
           (3 6 9))
         (transpose
           '((1 2 3)
             (4 5 6)
             (7 8 9))))))

(deftest matrix-*-matrix-test
  (is (= '((19 22)
           (43 50))
         (matrix-*-matrix
           '((1 2)
             (3 4))
           '((5 6)
             (7 8))))))
