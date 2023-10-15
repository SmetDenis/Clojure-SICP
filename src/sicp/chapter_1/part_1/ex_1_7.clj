(ns sicp.chapter-1.part_1.ex-1-7)

; Exercise 1.7
; The `good-enough?` test used in computing square roots will not be very effective
; for finding the square roots of very small numbers.
; Also, in real computers, arithmetic operations are almost always performed with limited precision.
; This makes our test inadequate for very large numbers.

; Explain these statements, with examples showing how the test fails for small and large numbers.
; An alternative strategy for implementing `good-enough?`
; is to watch how guess changes from one iteration to the next and to stop when the change
; is a very small fraction of the guess.
; Design a square-root procedure that uses this kind of end test.

; Does this work better for small and large numbers?

(defn average
  [a b]
  (/ (+ a b) 2))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn square
  [x]
  (* x x))

(defn good-enough?
  [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter
  [guess x]
  (if
    (good-enough? guess x)
    guess
    (do
      ; (println guess)                                       ; Uncomment to track precision
      (sqrt-iter (improve guess x) x))))

; Imporovments
(defn good-enough-v2?
  [guess1 guess2]
  (< (abs (- guess1 guess2)) 0.001))

(defn sqrt-iter-v2
  [guess x]
  (if (good-enough-v2? guess (improve guess x))
    guess
    (do
      ; (println guess)                                       ; Uncomment to track precision
      (sqrt-iter-v2 (improve guess x) x))))
