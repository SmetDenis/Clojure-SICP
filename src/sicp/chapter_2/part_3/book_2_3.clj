(ns sicp.chapter-2.part-3.book-2-3)

(comment "2.3")
; Symbolic Data ------------------------------------------------------------------------------------

(comment "2.3.1")
; Quotation ----------------------------------------------------------------------------------------
; Exercises:
; * 2.53
; * 2.54
; * 2.55

(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (memq item (rest x))))

(comment "2.3.2")
; Example: Symbolic Differentiation ----------------------------------------------------------------
; Exercises:
; * 2.56
; * 2.57
; * 2.58

(defn variable? [x] (symbol? x))
(defn same-variable? [v1 v2] (and (variable? v1) (variable? v2) (= v1 v2)))
(defn make-sum [a1 a2]
  (cond
    (= a1 0) a2
    (= a2 0) a1
    (and (number? a1) (number? a2)) (+ a1 a2)
    :else (list '+ a1 a2)))

(defn =number? [exp num]
  (and (number? exp) (= exp num)))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

(defn sum? [x] (and (sequential? x) (= (first x) '+)))
(defn addend [s] (second s))
(defn augend [s] (nth s 2))
(defn product? [x] (and (sequential? x) (= (first x) '*)))
(defn multiplier [p] (second p))
(defn multiplicand [p] (nth p 2))

(defn deriv [exp var]
  (cond
    (number? exp) 0
    (variable? exp) (if (same-variable? exp var) 1 0)
    (sum? exp) (make-sum (deriv (addend exp) var)
                         (deriv (augend exp) var))
    (product? exp) (make-sum
                     (make-product
                       (multiplier exp)
                       (deriv (multiplicand exp) var))
                     (make-product
                       (deriv (multiplier exp) var)
                       (multiplicand exp)))
    :else (throw (Exception. (str "unknown expression type: DERIV" exp)))))
