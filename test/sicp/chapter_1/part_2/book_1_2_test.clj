(ns sicp.chapter-1.part-2.book-1-2-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-2.book-1-2 :as book]))

(comment "1.2.1")
; Linear Recursion and Iteration -------------------------------------------------------------------

(deftest factorial-test
  (is (= 1 (book/factorial 1)))
  (is (= 2 (book/factorial 2)))
  (is (= 6 (book/factorial 3)))
  (is (= 24 (book/factorial 4)))
  (is (= 120 (book/factorial 5)))
  (is (= 720 (book/factorial 6))))

(deftest factorial-iter-test
  (is (= 1 (book/factorial-iter 1)))
  (is (= 2 (book/factorial-iter 2)))
  (is (= 6 (book/factorial-iter 3)))
  (is (= 24 (book/factorial-iter 4)))
  (is (= 120 (book/factorial-iter 5)))
  (is (= 720 (book/factorial-iter 6))))

(comment "1.2.2")
; Tree Recursion -----------------------------------------------------------------------------------

(deftest fib-test
  (is (= 5 (book/fib 5)))
  (is (= 55 (book/fib 10)))
  (is (= 6765 (book/fib 20))))

(deftest fib-2-test
  (is (= 5 (book/fib-2 5)))
  (is (= 55 (book/fib-2 10)))
  (is (= 6765 (book/fib-2 20))))

(deftest count-change-test
  (is (= 1 (book/count-change 1)))
  (is (= 4 (book/count-change 10)))
  (is (= 50 (book/count-change 50)))
  (is (= 292 (book/count-change 100))))

(comment "1.2.3")
; Orders of Growth ---------------------------------------------------------------------------------
; There are no code examples for this part in the book :(

(comment "1.2.4")
; Exponentiation -----------------------------------------------------------------------------------

(deftest expt-test
  (is (= 1 (book/expt 1 2)))
  (is (= 32 (book/expt 2 5)))
  (is (= 1024 (book/expt 2 10)))
  (is (= 59049 (book/expt 3 10))))

(deftest expt-2-test
  (is (= 1 (book/expt-2 1 2)))
  (is (= 32 (book/expt-2 2 5)))
  (is (= 1024 (book/expt-2 2 10)))
  (is (= 59049 (book/expt-2 3 10))))

(deftest even?-alt-test
  (is (= false (book/even?-alt 1)))
  (is (= true (book/even?-alt 2)))
  (is (= false (book/even?-alt 3)))
  (is (= true (book/even?-alt 4))))

(comment "1.2.5")
; Greatest Common Divisors -------------------------------------------------------------------------

(deftest gcd-test
  (is (= 8 (book/gcd 56 48)))
  (is (= 1 (book/gcd 101 103)))
  (is (= 12 (book/gcd 36 48)))
  (is (= 5 (book/gcd 5 0)))
  (is (= 5 (book/gcd 0 5)))
  (is (= 0 (book/gcd 0 0)))
  (is (= 21 (book/gcd 21 21)))
  (is (= 1 (book/gcd 17 19))))

(comment "1.2.6")
; Example: Testing for Primality -------------------------------------------------------------------

(deftest smallest-divisor-test
  (is (= 1 (book/smallest-divisor 1)))
  (is (= 2 (book/smallest-divisor 2)))
  (is (= 2 (book/smallest-divisor 10)))
  (is (= 3 (book/smallest-divisor 21)))
  (is (= 7 (book/smallest-divisor 1001))))

(deftest prime?-test
  (is (= true (book/prime? 7)))
  (is (= false (book/prime? 21))))

(deftest expmod-test
  (is (= 1 (book/expmod 3 0 5)))
  (is (= 1 (book/expmod 3 4 2)))
  (is (= 81 (book/expmod 3 4 100)))
  (is (= 16 (book/expmod 2 4 20)))
  (is (= 0 (book/expmod 2 3 4)))
  (is (= 7 (book/expmod 5 2 9))))

(deftest fermat-test-test
  (is (true? (book/fermat-test 2)))
  ; (is (false? (book/fermat-test 4)))                      ; Not stable due to random
  (is (true? (book/fermat-test 3)))
  ; (is (false? (book/fermat-test 9)))                      ; Not stable due to random

  ; Tests with large numbers can be unstable,
  ; since fermat-test uses random numbers
  (is (true? (or (true? (book/fermat-test 101))
                 (false? (book/fermat-test 101))))))

(deftest fast-prime?-test
  ; Tests for prime numbers
  (is (book/fast-prime? 2 10))
  (is (book/fast-prime? 3 10))
  (is (book/fast-prime? 5 10))
  (is (book/fast-prime? 7 10))
  (is (book/fast-prime? 11 10))

  ; Tests for composite numbers
  (is (not (book/fast-prime? 4 10)))
  (is (not (book/fast-prime? 6 10)))
  (is (not (book/fast-prime? 8 10)))
  (is (not (book/fast-prime? 9 10)))
  (is (not (book/fast-prime? 12 10)))

  ; Boundary conditions
  (is (not (book/fast-prime? 1 10)))
  (is (book/fast-prime? 2 0))                               ; times = 0, must be true
  (is (book/fast-prime? 4 0)))                              ; times = 0, must be true, but is not prime
