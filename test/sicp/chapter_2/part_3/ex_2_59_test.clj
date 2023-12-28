(ns sicp.chapter-2.part-3.ex-2-59-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-3.ex-2-59 :refer [union-set]]))

(deftest union-set-test
  (is (= '(1 2 3 4 5) (union-set '(1 2 3) '(3 4 5)))))
