(ns sicp.misc)

(defn square
  [x]
  (* x x))

(defn cube
  [x]
  (* x x x))

(defn divides?
  [a b]
  (zero? (rem b a)))

(defn find-divisor
  [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (divides? test-divisor n) test-divisor
    :else (recur n (inc test-divisor))))

(defn smallest-divisor
  [n]
  (find-divisor n 2))

(defn prime?
  [n]
  (= n (smallest-divisor n)))
