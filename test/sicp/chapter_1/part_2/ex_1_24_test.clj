(ns sicp.chapter-1.part-2.ex-1-24-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-24 :refer [fast-prime? fermat-test]]))

(deftest fast-prime?-test
  (is (= false (fast-prime? 100 100))))

(deftest fermat-test-test
  (is (= false (fermat-test 1)))
  (is (= false (fermat-test 2)))
  (is (= false (fermat-test 3)))
  (is (= false (fermat-test 5)))
  (is (= false (fermat-test 6)))
  (is (= false (fermat-test 11)))
  (is (= false (fermat-test 21))))
