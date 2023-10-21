(ns sicp.chapter-1.part-3.ex-1-31-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-31 :refer [factorial pi pi-iter]]))

(def pi_manual (* 4.0
                  (/ (* 2 4 4 6 6 8 8)
                     (* 3 3 5 5 7 7 9))))

(deftest factorial-test
  (is (= 1 (factorial 1)))
  (is (= 2 (factorial 2)))
  (is (= 6 (factorial 3)))
  (is (= 24 (factorial 4)))
  (is (= 120 (factorial 5)))
  (is (= 720 (factorial 6))))

(deftest pi-test
  (is (= pi_manual (pi 8)))
  (is (= 3.1400238186005973 (pi 1000))))

(deftest pi-iter-test
  (is (= pi_manual (pi-iter 8)))
  (is (= 3.1400238186005973 (pi-iter 1000)))
  (is (= 3.141278572846975 (pi-iter 5000))))                ; (pi 5000) is imposible in clojure at this moment

