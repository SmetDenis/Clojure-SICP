(ns sicp.chapter-2.part-3.book-2-3-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.book-2-3 :refer [adjoin-set
                                                    deriv
                                                    element-of-set-sorted?
                                                    element-of-set?
                                                    intersection-set
                                                    intersection-set-sorted
                                                    memq]]))

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

(comment "2.3.3")
; Example: Representing Sets -----------------------------------------------------------------------

(deftest element-of-set?-test
  (is (= true (element-of-set? 1 '(1 2 3))))
  (is (= false (element-of-set? 1 '(2 3))))
  (is (= false (element-of-set? 1 '())))
  (is (= false (element-of-set? nil '()))))

(deftest adjoin-set-test
  (is (= '(4) (adjoin-set 4 '())))
  (is (= '(4 1 2 3) (adjoin-set 4 '(1 2 3))))
  (is (= '(1 2 3) (adjoin-set 1 '(1 2 3)))))

(deftest intersection-set-test
  (is (= '() (intersection-set '(1 2) '(3 4))))
  (is (= '(3 4) (intersection-set '(3 4 5) '(3 4))))
  (is (= '(4) (intersection-set '(4) '(3 4))))
  (is (= '(15 16 17 18 19) (intersection-set (range 20) (range 15 25)))))

(deftest element-of-set-optimized?-test
  (is (= true (element-of-set-sorted? 1 '(1 2 3))))
  (is (= false (element-of-set-sorted? 1 '(2 3))))
  (is (= false (element-of-set-sorted? 1 '())))
  (is (= false (element-of-set-sorted? nil '())))
  (is (= true (element-of-set-sorted? 100 (range 10000000))))) ; faster than element-of-set?

(deftest intersection-set-sorted-test
  (is (= '() (intersection-set-sorted '(1 2) '(3 4))))
  (is (= '(3 4) (intersection-set-sorted '(3 4 5) '(3 4))))
  (is (= '(4) (intersection-set-sorted '(4) '(3 4))))
  (is (= '(15 16 17 18 19) (intersection-set-sorted (range 20) (range 15 25)))))
