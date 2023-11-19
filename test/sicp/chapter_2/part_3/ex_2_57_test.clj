(ns sicp.chapter-2.part-3.ex-2-57-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-57 :refer [augend deriv make-product make-sum multiplicand]]))

(deftest augend-test
  (is (= 5 (augend '(+ 1 2 3)))))

(deftest make-sum-test
  (is (= 3 (make-sum 1 2)))
  (is (= 6 (make-sum 1 2 3)))
  (is (= '(+ :a 2 3) (make-sum :a 2 3))))

(deftest multiplicand-test
  (is (= 3 (multiplicand '(* 2 3))))
  (is (= 12 (multiplicand '(* 2 3 4))))
  (is (= '(* :a 4) (multiplicand '(* 2 :a 4)))))

(deftest make-product-test
  (is (= 6 (make-product 2 3)))
  (is (= 24 (make-product 2 3 4)))
  (is (= '(* :a 2 3) (make-product :a 2 3))))

(deftest deriv-test
  (is (= '(+ (* x (+
                    (* y (+ (* (+ x 3) 0) 1))
                    (* 0 (* (+ x 3)))))
             (* 1 (* y (+ x 3))))                           ; 2xy+3y
         (deriv '(* x y (+ x 3)) 'x))))
