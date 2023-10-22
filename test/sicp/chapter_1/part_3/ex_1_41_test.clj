(ns sicp.chapter-1.part-3.ex-1-41-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-41 :refer [double-fn]]))

(deftest double-fn-test
  (is (= 3 ((double-fn inc) 1)))
  (is (= 21 (((double-fn (double-fn double-fn)) inc) 5))))
