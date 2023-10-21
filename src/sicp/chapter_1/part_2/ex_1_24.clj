(ns sicp.chapter-1.part_2.ex-1-24)

; Exercise 1.24
; Modify the timed-prime-test procedure of Exercise 1.22 to use fast-prime? (the Fermat method),
; and test each of the 12 primes you found in that exercise.
;
; Since the Fermat test has Θ(logn) growth, how would you expect the time to test primes near 1,000,000
; to compare with the time needed to test primes near 1000? Do your data bear this out?
;
; Can you explain any discrepancy you find?

; TODO: Improve benchmarking
; TODO: Improve add transparent solution

(defn expmod [base exp m]
  (mod (Math/pow base exp) m))

(defn fermat-test [n]
  (let [try-it (fn [a] (= (expmod a n n) a))
        a      (rand-int (dec n))]
    (try-it (inc a))))

(defn fast-prime?
  [n times]
  (cond (= times 0) true
        (fermat-test n) (fast-prime? n (- times 1))
        :else false))
