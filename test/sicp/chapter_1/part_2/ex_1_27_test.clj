(ns sicp.chapter-1.part-2.ex-1-27-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.ex-1-27 :refer [fermat-test]]))

(deftest fermat-test-test
  (is (= true (fermat-test 561)))
  (is (= true (fermat-test 1105)))
  (is (= true (fermat-test 1729)))
  (is (= true (fermat-test 2465)))
  (is (= true (fermat-test 2821)))
  (is (= true (fermat-test 6601))))
