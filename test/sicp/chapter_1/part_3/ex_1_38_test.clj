(ns sicp.chapter-1.part-3.ex-1-38-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-38 :refer [euler-fraction]]
            [sicp.misc :as m]))

(def e-2 (- Math/E 2))                                      ; 0.7182818284590451
(def precision 0.000001)

(deftest euler-fraction-test
  (is (= false (m/close-enough? e-2 (euler-fraction 1) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 2) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 3) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 4) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 5) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 6) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 7) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 8) precision)))
  (is (= false (m/close-enough? e-2 (euler-fraction 9) precision)))
  (is (= true (m/close-enough? e-2 (euler-fraction 10) precision))))
