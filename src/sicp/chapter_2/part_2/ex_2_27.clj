(ns sicp.chapter-2.part-2.ex-2-27
  (:require [sicp.misc :as m]))

; Exercise 2.27
;
; Modify your reverse procedure of Exercise 2.18 to produce a deep-reverse procedure
; that takes a list as argument and returns as its value the list with its elements
; reversed and with all sublists deep-reversed as well.
;
; For example,
; (define x (list (list 1 2) (list 3 4)))                     ; ((1 2) (3 4))
; (reverse x)                                                 ; ((3 4) (1 2))
; (deep-reverse x)                                            ; ((4 3) (2 1))
;

(defn deep-reverse [items]
  (if (empty? items)
    '()
    (m/append (deep-reverse (m/cdr items))
              (list (deep-reverse (m/car items))))))

;(defn deep-reverse [items]
;  (cond (empty? items) nil
;        (not (list? items)) items
;        :else (m/append (deep-reverse (m/cdr items))
;                        (list (deep-reverse (m/car items))))))))

(println (deep-reverse (list (list 1 2) (list 3 4))))

(count (list (list 1 2) (list 3 4)))


