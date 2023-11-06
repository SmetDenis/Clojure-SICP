(ns sicp.chapter-2.part-2.ex-2-40-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-40 :refer [prime-sum-pairs]]))

(deftest prime-sum-pairs-test
  (is (= '((2 1 3)
           (3 2 5)
           (4 1 5)
           (4 3 7)
           (5 2 7)) (prime-sum-pairs 5))))
