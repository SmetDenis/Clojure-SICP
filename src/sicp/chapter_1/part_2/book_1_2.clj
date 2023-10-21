(ns sicp.chapter-1.part-2.book-1-2
  (:require [sicp.misc :as m]))

(comment "1.2.1")
; Linear Recursion and Iteration -------------------------------------------------------------------
; Exercises:
; * 1.9
; * 1.10

(defn factorial
  [n]
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(defn fact-iter
  [product counter max-count]
  (if (> counter max-count)
    product
    (fact-iter (* counter product)
               (+ counter 1)
               max-count)))

(defn factorial-iter [n]
  (fact-iter 1 1 n))

(comment "1.2.2")
; Tree Recursion -----------------------------------------------------------------------------------
; Exercises:
; * 1.11
; * 1.12
; * 1.13

(defn fib [n]
  (cond (= n 0) 0
        (= n 1) 1
        :else (+ (fib (- n 1))
                 (fib (- n 2)))))

(defn fib-iter [a b count]
  (if (= count 0)
    b
    (fib-iter (+ a b) a (- count 1))))

(defn fib-2 [n]
  (fib-iter 1 0 n))

(defn first-denomination
  [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        (= kinds-of-coins 5) 50))

(defn cc
  [amount kinds-of-coins]
  (cond (= amount 0) 1
        (or (< amount 0)
            (= kinds-of-coins 0)) 0
        :else (+ (cc amount (- kinds-of-coins 1))
                 (cc (- amount (first-denomination
                                 kinds-of-coins))
                     kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))

(comment "1.2.3")
; Orders of Growth ---------------------------------------------------------------------------------
; There are no code examples for this part in the book :(
; Exercises:
; * 1.14
; * 1.15

(comment "1.2.4")
; Exponentiation -----------------------------------------------------------------------------------
; Exercises:
; * 1.16
; * 1.17
; * 1.18
; * 1.19

(defn expt
  [b n]
  (if (= n 0)
    1
    (* b (expt b (- n 1)))))

(defn expt-iter
  [b counter product]
  (if (= counter 0)
    product
    (expt-iter b
               (- counter 1)
               (* b product))))

(defn expt-2
  [b n]
  (expt-iter b n 1))

(defn fast-expt
  [b n]
  (cond (= n 0) 1
        (even? n) (m/square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))

(defn even?-alt [n]
  (= (rem n 2) 0))

(comment "1.2.5")
; Greatest Common Divisors -------------------------------------------------------------------------
; Exercises:
; * 1.20

(defn gcd
  [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(comment "1.2.6")
; Example: Testing for Primality -------------------------------------------------------------------
; Exercises:
; * 1.21
; * 1.22
; * 1.23
; * 1.24
; * 1.25
; * 1.26
; * 1.27
; * 1.28

(defn find-divisor
  [n test-divisor]
  (cond (> (m/square test-divisor) n) n
        (m/divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn expmod
  [base exp m]
  (cond (= exp 0) 1
        (even? exp) (rem (m/square (expmod base (/ exp 2) m)) m)
        :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test
  [n]
  (let [try-it (fn [a] (= (expmod a n n) a))
        a      (rand-int (dec n))]
    (try-it (inc a))))

(defn fast-prime?
  [n times]
  (cond (= times 0) true
        (fermat-test n) (fast-prime? n (- times 1))
        :else false))
