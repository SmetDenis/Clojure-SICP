(ns sicp.chapter-1.part-2.ex-1-26
  (:require [misc :refer [square]]))

; Exercise 1.26
; Louis Reasoner is having great difficulty doing Exercise 1.24.
; His fast-prime? test seems to run more slowly than his prime? test.
;
; Louis calls his friend Eva Lu Ator over to help.
; When they examine Louis’s code, they find that he has rewritten
; the expmod procedure to use an explicit multiplication, rather than calling square:

(defn expmod
  [base exp m]
  (cond (= exp 0) 1
        (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
        :else (rem (* base (expmod base (dec exp) m)) m)))

; “I don’t see what difference that could make,” says Louis. “I do.” says Eva. “By writing the procedure like that,
; you have transformed the Θ(logn) process into a Θ(n) process.” Explain.

; ----
; When you use applicative substitution, each expmod call runs twice.
; So even if the problem size is cut in half, the number of calls doubles.
; This makes it as slow as O(n).

; If you use squaring instead of multiplication, you only have one expmod call each time.
; Since you're also cutting the problem in half, it's much faster and works in a logarithmic time.
