(ns sicp.chapter-1.part-3.ex-1-38
  (:require
    [sicp.chapter-1.part-3.ex-1-37 :as ex-1-37]))

; Exercise 1.38
; In 1737, the Swiss mathematician Leonhard Euler published a memoir De Fractionibus Continuis,
; which included a continued fraction expansion for e−2, where e is the base of the natural logarithms.
; In this fraction, the Ni are all 1, and the Di are successively 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8 ...

; Write a program that uses your cont-frac procedure from Exercise 1.37
; to approximate e, based on Euler’s expansion

; Sequences:
; Di     = 1   2 1 1  4 1 1  6 1  1   8  1  1  10  1  1  12  1  1  14  1  1  18  1 1  20  1  1  22
; i      = 1   2 3 4  5 6 7  8 9 10  11 12 13  14 15 16  17 18 19  20 21 22  23 24 25 26 27 28  29
; SpikeN =     0      1      2        3         4         5         6         7        8         9

(defn euler-fraction
  [k]
  (ex-1-37/cont-frac-iter
    (fn [_] 1.0)
    (fn [i]
      (if (= i 1)
        1
        (if (pos? (rem (- i 2) 3))
          1                                                 ; Each second and third values
          (* 2 (inc (/ (- i 2) 3))))))                      ; 2 * ( ( (i-2)/3) + 1)
    k))
