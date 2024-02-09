(ns sicp.chapter-1.part-2.ex-1-25
  (:require
    [sicp.misc :as m]))

; Exercise 1.25
; Alyssa P. Hacker complains that we went to a lot of extra work in writing expmod
; After all, she says, since we already know how to compute exponentials, we could have simply written.

; (define (expmod base exp m)
;        (remainder (fast-expt base exp) m))

; Is she correct? Would this procedure serve as well for our fast prime tester? Explain.

(defn fast-expt
  [b n]
  (cond (zero? n) 1
        (even? n) (m/square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (dec n)))))

(defn expmod-alyssa
  [base exp m]
  (rem (fast-expt base exp) m))

(defn expmod
  [base exp m]
  (cond (zero? exp) 1
        (even? exp)
        (rem (m/square (expmod base (/ exp 2) m)) m)
        :else (rem (* base (expmod base (dec exp) m)) m)))
