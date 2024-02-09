(ns sicp.chapter-2.part-2.ex-2-20-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-20 :refer [same-parity]]))

(deftest same-parity-test
  (is (= '(2 4 6) (same-parity 2 3 4 5 6 7)))
  (is (= '(1 3 5 7) (same-parity 1 2 3 4 5 6 7))))
