(ns sicp.chapter-1.ex-1-17-test
  (:require [clojure.test :refer :all]
            [sicp.chapter-1.ex-1-17 :refer [multi multi-fast]]))

(deftest multi-test
  (time (is (= 2 (multi 1 2))))                             ; "Elapsed time: 2.383128 msecs"
  (time (is (= 50 (multi 10 5))))                           ; "Elapsed time: 1.087389 msecs"
  (time (is (= 6703582689499996764
               (multi 12345340404 543005091))))             ; "Elapsed time: 0.852849 msecs"
)

(deftest multi-fast-test
  (time (is (= 2 (multi-fast 1 2))))                        ; "Elapsed time: 1.258788 msecs"
  (time (is (= 50 (multi-fast 10 5))))                      ; "Elapsed time: 1.582771 msecs"
  (time (is (= 6703582689499996764
               (multi-fast 12345340404 543005091))))        ; "Elapsed time: 1.01612 msecs"
)