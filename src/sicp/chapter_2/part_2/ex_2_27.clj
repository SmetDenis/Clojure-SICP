(ns sicp.chapter-2.part-2.ex-2-27)

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

(defn deep-reverse [coll]
  (if (list? coll)
    (map deep-reverse (reverse coll))
    coll))
