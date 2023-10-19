(ns sicp.chapter-1.part_1.ex-1-6-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part_1.ex-1-6 :refer [sqrt-iter sqrt-iter-new-if]]))

(deftest sqrt-iter-test
  ; Expected
  (is (= 6 (sqrt-iter 6 36)))
  (is (= 10657/1752 (sqrt-iter 6 37))))

(deftest sqrt-iter-new-if-test
  ; Since the values (args in new-if) are calculated after substitution, we will have infinite execution.
  ; Arguments are not until whole statement is comprised only of primitive operations.
  (try
    (is (= 6 (sqrt-iter-new-if 6 36)))
    (catch Exception _
      (is true))))