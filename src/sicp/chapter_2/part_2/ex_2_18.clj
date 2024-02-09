(ns sicp.chapter-2.part-2.ex-2-18
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.misc :as m]))

; Exercise 2.18
; Define a procedure reverse that takes a list as argument and returns a list of the
; same elements in reverse order:
;
; (reverse (list 1 4 9 16 25))
; (25 16 9 4 1)

(defn list-reverse
  [items]
  (if (m/list-empty? items)
    '()
    (b22/append (list-reverse (m/cdr items)) (list (m/car items)))))
