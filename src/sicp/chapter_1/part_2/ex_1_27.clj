(ns sicp.chapter-1.part-2.ex-1-27)

; Exercise 1.27
; Demonstrate that the Carmichael numbers listed in Footnote 47 really do fool the Fermat test.
; That is, write a procedure that takes an integer n and tests whether an is congruent to a modulo n
; for every a<n, and try your procedure on the given Carmichael numbers.

(defn square [n]
  (* n n))

(defn divides? [a b]
  (zero? (rem b a)))

(defn find-divisor [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (divides? test-divisor n) test-divisor
    :else (recur n (inc test-divisor))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn expmod [base exp m]
  (cond
    (= exp 0) 1
    (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
    :else (rem (* base (expmod base (dec exp) m)) m)))

(defn fermat-test [n]
  (defn test [a]
    (= (expmod a n n) a))
  (defn iter [a]
    (if (< a n)
      (if (test a)
        (recur (inc a))
        false)
      true))
  (iter 1))
