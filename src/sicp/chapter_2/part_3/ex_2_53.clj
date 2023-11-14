(ns sicp.chapter-2.part-3.ex-2-53
  (:require [sicp.misc :as m]
            [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.53
;
; What would the interpreter print in response to evaluating each of the following expressions?
;
; (list 'a 'b 'c)
; (list (list 'george))
; (cdr '((x1 x2) (y1 y2)))
; (cadr '((x1 x2) (y1 y2)))
; (pair? (car '(a short list)))
; (memq 'red '((red shoes) (blue socks)))
; (memq 'red '(red shoes blue socks))

(defn print-vars []
  [(list 'a 'b 'c)                                          ; (a b c)
   (list (list 'george))                                    ; ((george))
   (m/cdr '((x1 x2) (y1 y2)))                               ; (y1 y2)
   (m/cadr '((x1 x2) (y1 y2)))                              ; (y1 y2)
   (m/pair? (m/car '(a short list)))                        ; false
   (b23/memq 'red '((red shoes) (blue socks)))              ; false
   (b23/memq 'red '(red shoes blue socks))])                ; (red shoes blue socks)

