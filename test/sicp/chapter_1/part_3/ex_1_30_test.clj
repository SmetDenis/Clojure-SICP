(ns sicp.chapter-1.part-3.ex-1-30-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-30 :refer [sum-2]]
            [sicp.misc :refer [cube square]]))

(deftest sum-2-test
  (is (= 385 (sum-2 square 1 inc 10)))
  (is (= 3025 (sum-2 cube 1 inc 10))))
