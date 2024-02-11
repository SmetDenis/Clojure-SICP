(ns sicp.chapter-1.part-3.ex-1-45-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-3.ex-1-45 :refer [damp-number nth-root nth-root-auto-damps]]))

(deftest nth-root-test
  (is (= 2.0000000000039666 (nth-root 256 8 3))))

(deftest damp-number-test
  (is (= 0 (damp-number 1)))
  (is (= 1 (damp-number 2)))
  (is (= 1 (damp-number 3)))
  (is (= 2 (damp-number 4)))
  (is (= 2 (damp-number 5)))
  (is (= 2 (damp-number 6)))
  (is (= 2 (damp-number 7)))
  (is (= 3 (damp-number 8)))
  (is (= 3 (damp-number 9)))
  (is (= 3 (damp-number 10)))
  (is (= 6 (damp-number 100)))
  (is (= 9 (damp-number 1000)))
  (is (= 13 (damp-number 10000))))

(deftest nth-root-auto-damps-test
  (is (= 2.0000000000039666 (nth-root-auto-damps 256 8))))
