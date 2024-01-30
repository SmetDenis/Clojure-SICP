(ns sicp.chapter-2.part-3.ex-2-67
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.67
;
; Define an encoding tree and a sample message
;
; (define sample-tree
;   (make-code-tree
;    (make-leaf 'A 4)
;    (make-code-tree
;     (make-leaf 'B 2)
;     (make-code-tree
;      (make-leaf 'D 1)
;      (make-leaf 'C 1)))))
;
; (define sample-message
;   '(0 1 1 0 0 1 0 1 0 1 1 1 0))

(defn decode-message [message tree]
  (b23/decode message tree))
