(ns sicp.chapter-2.part-2.ex-2-43-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-43 :refer [queens-2-42 queens-2-43]]))

(deftest queens-2-42-test
  (is (= 10 (count (queens-2-42 5))))                       ; Elapsed time: 6.745917 msecs
  (is (= 04 (count (queens-2-42 6))))                       ; Elapsed time: 4.257555 msecs
  (is (= 40 (count (queens-2-42 7)))))                      ; Elapsed time: 3.833679 msecs

(deftest queens-2-43-test
  (is (= 10 (count (queens-2-43 5))))                       ; Elapsed time: 4.883081 msecs
  (is (= 04 (count (queens-2-43 6))))                       ; Elapsed time: 7.733293 msecs
  (is (= 40 (count (queens-2-43 7)))))                      ; Elapsed time: 6.069276 msecs

; The exercise's method requires O(n^n) recursive calls (instead of O(n))
; exponentially increasing time resource use.
