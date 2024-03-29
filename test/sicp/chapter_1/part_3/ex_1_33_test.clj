(ns sicp.chapter-1.part-3.ex-1-33-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-3.ex-1-33 :refer [filtered-accumulate
                                           filtered-accumulate-iter
                                           product-of-primes
                                           sum-of-primes]]
    [sicp.misc :as m]))

(deftest filtered-accumulate-test
  (is (= 1061 (filtered-accumulate + 0 identity 1 inc 100 m/prime?)))
  (is (= 1061 (filtered-accumulate-iter + 0 identity 1 inc 100 m/prime?))))

(deftest sum-of-primes-test
  (is (= (+
           (* 1 1)
           (* 2 2)
           (* 3 3)
           (* 5 5)
           (* 7 7))
         (sum-of-primes 1 10)))                             ; 88
  (is (= (+
           (* 1 1)
           (* 2 2)
           (* 3 3)
           (* 5 5)
           (* 7 7)
           (* 11 11))
         (sum-of-primes 1 12))))                            ; 209

(deftest product-of-primes-test
  (is (= 1 (product-of-primes 1)))                          ; (* 1)
  (is (= 1 (product-of-primes 2)))                          ; (* 1)
  (is (= 2 (product-of-primes 3)))                          ; (* 1 2)
  (is (= 3 (product-of-primes 4)))                          ; (* 1 3)
  (is (= 24 (product-of-primes 5)))                         ; (* 1 2 3 4)
  (is (= 5 (product-of-primes 6)))                          ; (* 1 5)
  (is (= 720 (product-of-primes 7)))                        ; (* 1 2 3 4 5 6)
  (is (= 105 (product-of-primes 8)))                        ; (* 1 3 5 7)
  (is (= 2240 (product-of-primes 9)))                       ; (* 1 2 4 5 7 8)
  (is (= 189 (product-of-primes 10))))                      ; (* 1 3 7 9)
