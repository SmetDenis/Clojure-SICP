(ns sicp.chapter-1.part-3.ex-1-32-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-32 :refer [accumulate accumulate-iter factorial factorial-iter]]))

(deftest accumulate-test
  (is (= 55 (accumulate + 0 identity 1 inc 10)))
  (is (= 3628800 (accumulate * 1 identity 1 inc 10)))
  (is (= 55 (accumulate-iter + 0 identity 1 inc 10)))
  (is (= 3628800 (accumulate-iter * 1 identity 1 inc 10))))

(deftest factorial-test
  (is (= 720 (factorial 6)))
  (is (= 3628800 (factorial 10)))
  (is (= 720 (factorial-iter 6)))
  (is (= 3628800 (factorial-iter 10))))
