(ns sicp.chapter-2.part-2.ex-2-33
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]))

; Exercise 2.33
;
; Fill in the missing expressions to complete the following definitions of some basic
; list-manipulation operations as accumulations:
;
; (define (map p sequence)
;   (accumulate (lambda (x y) ⟨??⟩)
;               nil sequence))
;
; (define (append seq1 seq2)
;   (accumulate cons ⟨??⟩ ⟨??⟩))
;
; (define (length sequence)
;   (accumulate ⟨??⟩ 0 sequence))

(defn my-map
  [p sequence]
  (b22/accumulate (fn [x y] (cons (p x) y)) nil sequence))

(defn my-append
  [seq1 seq2]
  (b22/accumulate cons seq1 seq2))

(defn my-length
  [sequence]
  (b22/accumulate (fn [_ y] (inc y)) 0 sequence))
