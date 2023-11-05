(ns sicp.chapter-2.part-2.ex-2-34-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-34 :refer [horner-eval]]))

(deftest horner-eval-test
  (is (= 79 (horner-eval 2 '(1 3 0 5 0 1)))))
