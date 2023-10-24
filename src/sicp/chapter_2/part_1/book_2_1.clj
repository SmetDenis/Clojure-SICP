(ns sicp.chapter-2.part-1.book-2-1
  (:require [sicp.chapter-2.part-1.ex-2-07 :as ex-2-07]
            [sicp.misc :as m]))

(comment "2")
; Building Abstractions with Data ------------------------------------------------------------------

(defn linear-combination [a b x y]
  (+ (* a x) (* b y)))

; (defn linear-combination [a b x y]
;   (add (mul a x) (mul b y)))

(comment "2.1.1")
; Example: Arithmetic Operations for Rational Numbers ----------------------------------------------
; Exercises:
; * 2.1

; (defn make-rat [n d] (m/pair n d))
(defn make-rat [numer denom]
  (let [g (m/gcd numer denom)]
    (m/pair (/ numer g)
            (/ denom g))))

(defn numer [ratio]
  (m/car ratio))

(defn denom [ratio]
  (m/cdr ratio))

(defn add-rat [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))

(defn div-rat [x y]
  (make-rat (* (numer x) (denom y))
            (* (denom x) (numer y))))

(defn equal-rat? [x y]
  (= (* (numer x) (denom y))
     (* (numer y) (denom x))))

(defn print-rat [ratio]
  (str (numer ratio) "/" (denom ratio)))

(comment "2.1.2")
; Abstraction Barriers -----------------------------------------------------------------------------
; Exercises:
; * 2.2
; * 2.3

(defn make-rat-alt [numer denom]
  (m/pair numer denom))

(defn numer-alt [ratio]
  (let [g (m/gcd (m/car ratio) (m/cdr ratio))]
    (/ (m/car ratio) g)))

(defn denom-alt [ratio]
  (let [g (m/gcd (m/car ratio) (m/cdr ratio))]
    (/ (m/cdr ratio) g)))

(comment "2.1.3")
; What Is Meant by Data? ---------------------------------------------------------------------------
; Exercises:
; * 2.4
; * 2.5
; * 2.6

(defn pair-alt [x y]
  (let [dispatch (fn [m] (cond
                           (= m 0) x
                           (= m 1) y
                           :else (throw (Exception. "Argument not 0 or 1: CONS"))))]
    dispatch))

(defn car-alt [z] (z 0))
(defn cdr-alt [z] (z 1))

(comment "2.1.4")
; Extended Exercise: Interval Arithmetic -----------------------------------------------------------
; Exercises:
; * 2.7
; * 2.8
; * 2.9
; * 2.10
; * 2.11
; * 2.12
; * 2.13
; * 2.14
; * 2.15
; * 2.16

(defn mul-interval [x y]
  (let [p1 (* (ex-2-07/lower-bound x)
              (ex-2-07/lower-bound y))
        p2 (* (ex-2-07/lower-bound x)
              (ex-2-07/upper-bound y))
        p3 (* (ex-2-07/upper-bound x)
              (ex-2-07/lower-bound y))
        p4 (* (ex-2-07/upper-bound x)
              (ex-2-07/upper-bound y))]
    (ex-2-07/make-interval (min p1 p2 p3 p4)
                           (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (mul-interval x (ex-2-07/make-interval
                    (/ 1.0 (ex-2-07/upper-bound y))
                    (/ 1.0 (ex-2-07/lower-bound y)))))

(defn add-interval [x y]
  (ex-2-07/make-interval (+ (ex-2-07/lower-bound x)
                            (ex-2-07/lower-bound y))
                         (+ (ex-2-07/upper-bound x)
                            (ex-2-07/upper-bound y))))
