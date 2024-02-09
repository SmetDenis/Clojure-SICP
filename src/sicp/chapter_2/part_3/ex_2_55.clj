(ns sicp.chapter-2.part-3.ex-2-55
  (:require
    [sicp.misc :as m]))

; Exercise 2.55
;
; Eva Lu Ator types to the interpreter the expression
; (car ''abracadabra)
; To her surprise, the interpreter prints back quote. Explain.

; Apostrophe represents the function `(quote)`

(m/car ''abracadabra)                                       ; quote
(m/car (quote (quote abasdfa)))                             ; quote
(m/car '(quote abasdfa))                                    ; quote

(defn print-test
  []
  (m/car ''abracadabra))
