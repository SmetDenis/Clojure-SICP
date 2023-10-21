(ns sicp.chapter-1.part_2.ex-1-14)

; Exercise 1.14
; Draw the tree illustrating the process generated by the count-change procedure of 1.2.2 in making change for 11 cents.
; What are the orders of growth of the space and number of steps used by this process as the amount to be changed increases?

(defn first-denomination
  [type-of-coins]
  (cond (= type-of-coins 1) 1
        (= type-of-coins 2) 5
        (= type-of-coins 3) 10
        (= type-of-coins 4) 25
        (= type-of-coins 5) 50))

(defn change
  [amount type-of-coins]
  (cond (= amount 0) 1
        (or (< amount 0) (= type-of-coins 0)) 0
        :else (+ (change amount (- type-of-coins 1))
                 (change (- amount (first-denomination type-of-coins)) type-of-coins))))

(defn money-change [amount]
  (change amount 5))
