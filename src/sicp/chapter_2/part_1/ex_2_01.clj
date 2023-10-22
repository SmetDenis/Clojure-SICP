(ns sicp.chapter-2.part-1.ex-2-01
  (:require [sicp.misc :as m]))

; Exercise 2.1
; Define a better version of make-rat that handles both positive and negative arguments.
; Make-rat should normalize the sign so that
; if the rational number is positive, both the numerator and denominator are positive
; and if the rational number is negative, only the numerator is negative.

(defn make-rat-2 [numer denom]
  (let [devider      (abs (m/gcd numer denom))
        signed-numer (cond (and (< denom 0) (< numer 0)) (abs numer)
                           (and (< denom 0) (> numer 0)) (- numer)
                           :else numer)
        signed-denom (abs denom)]
    (m/pair (/ signed-numer devider)
            (/ signed-denom devider))))
