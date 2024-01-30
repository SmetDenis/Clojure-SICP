(ns sicp.chapter-1.part-2.ex-1-17-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-2.ex-1-17 :refer [multi multi-fast]]))

(deftest multi-test
  (is (= 2 (multi 1 2)))                                    ; "Elapsed time: 2.383128 msecs"
  (is (= 50 (multi 10 5)))                                  ; "Elapsed time: 1.087389 msecs"
  (is (= 6703582689499996764
         (multi 12345340404 543005091))))                   ; "Elapsed time: 0.852849 msecs"

(deftest multi-fast-test
  (is (= 2 (multi-fast 1 2)))                               ; "Elapsed time: 1.258788 msecs"
  (is (= 50 (multi-fast 10 5)))                             ; "Elapsed time: 1.582771 msecs"
  (is (= 6703582689499996764
         (multi-fast 12345340404 543005091))))              ; "Elapsed time: 1.01612 msecs"
