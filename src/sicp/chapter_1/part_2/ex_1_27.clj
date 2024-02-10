(ns sicp.chapter-1.part-2.ex-1-27
  (:require
    [sicp.misc :as m]))

; Exercise 1.27
; Demonstrate that the Carmichael numbers listed in Footnote 47 really do fool the Fermat test.
; That is, write a procedure that takes an integer n and tests whether an is congruent to a modulo n
; for every a<n, and try your procedure on the given Carmichael numbers.

(defn expmod
  [base exp m]
  (cond
    (= exp 0) 1
    (even? exp) (rem (m/square (expmod base (/ exp 2) m)) m)
    :else (rem (* base (expmod base (dec exp) m)) m)))

(defn fermat-test
  [n]
  (let [test (fn [a] (= (expmod a n n) a))
        iter (fn [a]
               (if (< a n)
                 (if (test a) (recur (inc a)) false)
                 true))]
    (iter 1)))
