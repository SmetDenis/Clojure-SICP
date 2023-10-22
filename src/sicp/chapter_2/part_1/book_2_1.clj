(ns sicp.chapter-2.part-1.book-2-1
  (:require [sicp.misc :as m]))

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
