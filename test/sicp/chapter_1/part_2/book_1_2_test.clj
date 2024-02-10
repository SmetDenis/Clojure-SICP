(ns sicp.chapter-1.part-2.book-1-2-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-2.book-1-2 :as b12]))

(comment "1.2.1 Linear Recursion and Iteration ---------------------------------------------------")

(deftest factorial-test
  (is (= 1 (b12/factorial 1)))
  (is (= 2 (b12/factorial 2)))
  (is (= 6 (b12/factorial 3)))
  (is (= 24 (b12/factorial 4)))
  (is (= 120 (b12/factorial 5)))
  (is (= 720 (b12/factorial 6))))

(deftest factorial-iter-test
  (is (= 1 (b12/factorial-iter 1)))
  (is (= 2 (b12/factorial-iter 2)))
  (is (= 6 (b12/factorial-iter 3)))
  (is (= 24 (b12/factorial-iter 4)))
  (is (= 120 (b12/factorial-iter 5)))
  (is (= 720 (b12/factorial-iter 6))))

(comment "1.2.2 Tree Recursion -------------------------------------------------------------------")

(deftest fib-test
  (is (= 5 (b12/fib 5)))
  (is (= 55 (b12/fib 10)))
  (is (= 6765 (b12/fib 20))))

(deftest fib-2-test
  (is (= 5 (b12/fib-2 5)))
  (is (= 55 (b12/fib-2 10)))
  (is (= 6765 (b12/fib-2 20))))

(deftest count-change-test
  (is (= 1 (b12/count-change 1)))
  (is (= 4 (b12/count-change 10)))
  (is (= 50 (b12/count-change 50)))
  (is (= 292 (b12/count-change 100))))

(comment "1.2.3 Orders of Growth -----------------------------------------------------------------")

; There are no code examples for this part in the book :(

(comment "1.2.4 Exponentiation -------------------------------------------------------------------")

(deftest expt-test
  (is (= 1 (b12/expt 1 2)))
  (is (= 32 (b12/expt 2 5)))
  (is (= 1024 (b12/expt 2 10)))
  (is (= 59049 (b12/expt 3 10))))

(deftest expt-2-test
  (is (= 1 (b12/expt-2 1 2)))
  (is (= 32 (b12/expt-2 2 5)))
  (is (= 1024 (b12/expt-2 2 10)))
  (is (= 59049 (b12/expt-2 3 10))))

(deftest even?-alt-test
  (is (false? (b12/even?-alt 1)))
  (is (true? (b12/even?-alt 2)))
  (is (false? (b12/even?-alt 3)))
  (is (true? (b12/even?-alt 4))))

(comment "1.2.5 Greatest Common Divisors ---------------------------------------------------------")

(deftest gcd-test
  (is (= 8 (b12/gcd 56 48)))
  (is (= 1 (b12/gcd 101 103)))
  (is (= 12 (b12/gcd 36 48)))
  (is (= 5 (b12/gcd 5 0)))
  (is (= 5 (b12/gcd 0 5)))
  (is (zero? (b12/gcd 0 0)))
  (is (= 21 (b12/gcd 21 21)))
  (is (= 1 (b12/gcd 17 19))))

(comment "1.2.6 Example: Testing for Primality ---------------------------------------------------")

(deftest smallest-divisor-test
  (is (= 1 (b12/smallest-divisor 1)))
  (is (= 2 (b12/smallest-divisor 2)))
  (is (= 2 (b12/smallest-divisor 10)))
  (is (= 3 (b12/smallest-divisor 21)))
  (is (= 7 (b12/smallest-divisor 1001))))

(deftest prime?-test
  (is (true? (b12/prime? 7)))
  (is (false? (b12/prime? 21))))

(deftest expmod-test
  (is (= 1 (b12/expmod 3 0 5)))
  (is (= 1 (b12/expmod 3 4 2)))
  (is (= 81 (b12/expmod 3 4 100)))
  (is (= 16 (b12/expmod 2 4 20)))
  (is (zero? (b12/expmod 2 3 4)))
  (is (= 7 (b12/expmod 5 2 9))))

(deftest fermat-test-test
  (is (true? (b12/fermat-test 2)))
  ; (is (false? (book/fermat-test 4)))                      ; Not stable due to random
  (is (true? (b12/fermat-test 3)))
  ; (is (false? (book/fermat-test 9)))                      ; Not stable due to random

  ; Tests with large numbers can be unstable,
  ; since fermat-test uses random numbers
  (is (true? (or (true? (b12/fermat-test 101))
                 (false? (b12/fermat-test 101))))))

(deftest fast-prime?-test
  ; Tests for prime numbers
  (is (b12/fast-prime? 2 10))
  (is (b12/fast-prime? 3 10))
  (is (b12/fast-prime? 5 10))
  (is (b12/fast-prime? 7 10))
  (is (b12/fast-prime? 11 10))

  ; Tests for composite numbers
  (is (not (b12/fast-prime? 4 10)))
  (is (not (b12/fast-prime? 6 10)))
  (is (not (b12/fast-prime? 8 10)))
  (is (not (b12/fast-prime? 9 10)))
  (is (not (b12/fast-prime? 12 10)))

  ; Boundary conditions
  (is (not (b12/fast-prime? 1 10)))
  (is (b12/fast-prime? 2 0))                                ; times = 0, must be true
  (is (b12/fast-prime? 4 0)))                               ; times = 0, must be true, but is not prime
