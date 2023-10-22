(ns sicp.misc)

(comment "Chapter #1")
; The Elements of Programming ----------------------------------------------------------------------

(defn square [x]
  (* x x))

(defn cube [x]
  (* x x x))

(defn divides? [a b]
  (zero? (rem b a)))

(defn find-divisor
  [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (divides? test-divisor n) test-divisor
    :else (recur n (inc test-divisor))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn close-enough?
  ([x y] (< (abs (- x y)) 0.001))
  ([x y tolerance] (< (abs (- x y)) tolerance)))

(defn average [a b]
  (/ (+ a b) 2))

(defn positive? [x]
  (> x 0))

(defn negative? [x]
  (< x 0))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(comment "Chapter #2")
; Introduction to Data Abstraction -----------------------------------------------------------------

(comment
  (def x [1 2])                                             ; (define x (cons 1 2))
  ; Get the first element, equivalent to car in Scheme
  (first x)                                                 ; (car x)
  ; Get the second element, equivalent to cdr in Scheme if cdr is a list with one element
  (second x))                                               ; (cdr x)

(defn pair [head tail]
  [head tail])

(defn car [pair]
  (first pair))

(defn cdr [pair]
  (second pair))
