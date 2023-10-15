(ns sicp.chapter-1.part_2.ex-1-21)

; Exercise 1.21
; Use the smallest-divisor procedure to find the smallest divisor of each of the following numbers:
; 199, 1999, 19999.

(defn divides? [a b]
  (= (mod b a) 0))

(defn find-divisor
  [number test-divisor]
  (cond (> (* test-divisor test-divisor) number) number
        (divides? test-divisor number) test-divisor
        :else (find-divisor number (+ test-divisor 1))))

(defn smallest-divisor
  [n]
  (find-divisor n 2))
