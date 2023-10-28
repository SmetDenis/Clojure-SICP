(ns sicp.misc)

(comment "Chapter #1")
; The Elements of Programming ----------------------------------------------------------------------

(defn error [error-message]
  (throw (Exception. (str error-message))))

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

(defn round-to-dec [n decimals]
  (let [factor (Math/pow 10 decimals)]
    (/ (Math/round (* n factor)) factor)))

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

(defn cdr [pair-list]
  (cond
    (vector? pair-list) (last pair-list)
    (or (list? pair-list)
        (= clojure.lang.LongRange (type pair-list))
        (= clojure.lang.Cons (type pair-list))) (rest pair-list)
    :else (error (str "Undefind input. Must be [x y] or '(a b c ...). "
                      "\"" (type pair-list) "\""
                      " given. See dump: "
                      pair-list))))

(defn make-interval [low high]
  (pair low high))

(defn lower-bound [interval]
  (car interval))

(defn upper-bound [interval]
  (cdr interval))

(defn mul-interval [interval-1 interval-2]
  (let [p1 (* (lower-bound interval-1)
              (lower-bound interval-2))
        p2 (* (lower-bound interval-1)
              (upper-bound interval-2))
        p3 (* (upper-bound interval-1)
              (lower-bound interval-2))
        p4 (* (upper-bound interval-1)
              (upper-bound interval-2))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval [interval-1 interval-2]
  (mul-interval interval-1 (make-interval
                             (/ 1.0 (upper-bound interval-2))
                             (/ 1.0 (lower-bound interval-2)))))

(defn add-interval [interval-1 interval-2]
  (make-interval (+ (lower-bound interval-1)
                    (lower-bound interval-2))
                 (+ (upper-bound interval-1)
                    (upper-bound interval-2))))

(defn sub-interval [interval-1 interval-2]
  (make-interval (- (lower-bound interval-1)
                    (lower-bound interval-2))
                 (- (upper-bound interval-1)
                    (upper-bound interval-2))))

(defn make-center-width [c w]
  (make-interval (- c w) (+ c w)))

(defn center-interval [interval]
  (/ (+ (lower-bound interval) (upper-bound interval)) 2.0))

(defn width-interval [interval]
  (/ (- (upper-bound interval) (lower-bound interval)) 2.0))

(defn print-interval
  ([interval]
   (print-interval interval 3))
  ([interval precision]
   (str "[" (round-to-dec (upper-bound interval) precision)
        ", " (round-to-dec (lower-bound interval) precision)
        "] / " (round-to-dec (center-interval interval) precision)
        "±" (round-to-dec (width-interval interval) precision))))
