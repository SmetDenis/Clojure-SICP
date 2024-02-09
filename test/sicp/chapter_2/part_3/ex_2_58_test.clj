(ns sicp.chapter-2.part-3.ex-2-58-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.ex-2-58 :refer [deriv]]))

(deftest deriv-test
  (is (= '((x * y) + (y * (x + 3)))                         ; (+ (* x y) (* y (+ x 3)))
         (deriv '((x * y) * (x + 3)) 'x)))
  (is (= 4 (deriv '(x + 3 * (x + y + 2)) 'x))))
