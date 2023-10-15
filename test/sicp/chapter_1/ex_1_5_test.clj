(ns sicp.chapter-1.ex-1-5-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.ex-1-5 :refer [test_1_5 p]]))

(deftest test_1_5-test
  ; Normal: Operand "p" will not be evaluated until it's needed by some primitive operation. So result is 0.
  (is (= 0 (test_1_5 0 p)))
  ; Applicative: Operand "y" will be by default evaluated. Then it will end up in recursion since (p) points to itself.
  (is (= p (test_1_5 1 p))))
