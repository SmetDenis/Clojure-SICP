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

; (defn make-rat [n d] (m/pair n d))
(defn make-rat [numer denom]
  (let [g (m/gcd numer denom)]
    (m/pair (/ numer g)
            (/ denom g))))

(defn numer [ratio] (m/car ratio))
(defn denom [ratio] (m/cdr ratio))

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
