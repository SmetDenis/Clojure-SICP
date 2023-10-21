(ns sicp.chapter-1.part-3.ex-1-33)

; Exercise 1.33
;
; You can obtain an even more general version of accumulate (Exercise 1.32)
; by introducing the notion of a filter on the terms to be combined.
;
; That is, combine only those terms derived from values in the range that satisfy a specified condition.
; The resulting filtered-accumulate abstraction takes the same arguments as accumulate,
; together with an additional predicate of one argument that specifies the filter.
; Write filtered-accumulate as a procedure. Show how to express the following using filtered-accumulate:
;
; 1. the sum of the squares of the prime numbers in the interval a to b
; (assuming that you have a prime? predicate already written)

; 2. the product of all the positive integers less than n
; that are relatively prime to n  (i.e., all positive integers i<n such that GCD(i,n)=1).

(defn filtered-accumulate
  [combiner null-value term a next b filter?]
  (if (> a b)
    null-value
    (if (filter? a)
      (combiner (term a)
                (filtered-accumulate combiner null-value term (next a) next b filter?))
      (combiner null-value
                (filtered-accumulate combiner null-value term (next a) next b filter?)))))

(defn filtered-accumulate-iter
  [combiner null-value term a next b filter?]
  (letfn [(iter [a result]
            (if (> a b)
              result
              (iter (next a)
                    (if (filter? a)
                      (combiner (term a) result)
                      result))))]
    (iter a null-value)))

; 1. ----------
(defn sum-of-primes
  [a b]
  (filtered-accumulate-iter + 0 sicp.misc/square a inc b sicp.misc/prime?))

; 2. ----------
(defn gcd
  [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn product-of-primes
  [number]
  (let [self-gcd? (fn [x] (= 1 (gcd x number)))]
    (filtered-accumulate-iter * 1 identity 1 inc number self-gcd?)))
