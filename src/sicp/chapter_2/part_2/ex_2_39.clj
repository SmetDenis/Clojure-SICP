(ns sicp.chapter-2.part-2.ex-2-39
  (:require [sicp.chapter-2.part-2.ex-2-38 :as ex-2-38]
            [sicp.misc :as m]))

; Exercise 2.39
;
; Complete the following definitions of reverse (Exercise 2.18) in terms of fold-right and
; fold-left from Exercise 2.38:
;
; (define (reverse sequence)
;   (fold-right
;    (lambda (x y) ⟨??⟩) nil sequence))
;
; (define (reverse sequence)
;   (fold-left
;    (lambda (x y) ⟨??⟩) nil sequence))

(defn reverse-right [sequence]
  (ex-2-38/fold-right (fn [x y] (m/append y (list x))) nil sequence))

(defn reverse-left [sequence]
  (ex-2-38/fold-left (fn [x y] (cons y x)) nil sequence))

;(reverse-right '(1 2 3))

