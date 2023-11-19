(ns sicp.chapter-2.part-3.book-2-3-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :refer [memq deriv]]))

(comment "2.3")
; Symbolic Data ------------------------------------------------------------------------------------

(comment "2.3.1")
; Quotation ----------------------------------------------------------------------------------------

(deftest memq-test
  (is (= false (memq 'apple '(pear banana prune))))
  (is (= '(pear banana prune) (memq 'pear '(pear banana prune))))
  (is (= '(apple pear) (memq 'apple '(x (apple sauce) y apple pear)))))

(comment "2.3.2")
; Example: Symbolic Differentiation ----------------------------------------------------------------

(deftest deriv-test
  (is (= 1 (deriv '(+ x 3) 'x)))
  (is (= 'y (deriv '(* x y) 'x)))
  (is (= '(+ (* x y) (* y (+ x 3)))
          (deriv '(* (* x y) (+ x 3)) 'x))))
