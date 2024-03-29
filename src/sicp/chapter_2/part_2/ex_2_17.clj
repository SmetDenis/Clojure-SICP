(ns sicp.chapter-2.part-2.ex-2-17
  (:require
    [sicp.misc :as m]))

; Exercise 2.17
; Define a procedure last-pair that returns the list that contains only the last element of
; a given (nonempty) list:
;
; (last-pair (list 23 72 149 34))
; (34)

(defn last-pair
  [items]
  (letfn [(iter
            [list-current result]
            (if (m/list-empty? list-current)
              result
              (iter
                (m/cdr list-current)
                (list (m/car list-current)))))]
    (iter items nil)))
