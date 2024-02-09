(ns sicp.chapter-2.part-2.ex-2-22
  (:require
    [sicp.misc :as m]))

; Exercise 2.22
;
; Louis Reasoner tries to rewrite the first square-list procedure of Exercise 2.21
; so that it evolves an iterative process:
;
; (define (square-list items)
;   (define (iter things answer)
;     (if (null? things)
;         answer
;         (iter (cdr things)
;               (cons (square (car things))
;                     answer))))
;   (iter items nil))
;
; Unfortunately, defining square-list this way produces the answer list in the reverse
; order of the one desired. Why?
;
; Louis then tries to fix his bug by interchanging the arguments to cons:
;
; (define (square-list items)
;   (define (iter things answer)
;     (if (null? things)
;         answer
;         (iter (cdr things)
;               (cons answer
;                     (square
;                      (car things))))))
;   (iter items nil))
;
; This doesn’t work either. Explain.

(defn square-list-1
  [items]
  (letfn [(iter
            [things answer]
            (if (m/list-empty? things)
              answer
              (iter (m/cdr things)
                    (cons (m/square (m/car things))
                          answer))))]
    (iter items nil)))

; (defn square-list-2 [items]
;   (letfn [(iter [things answer]
;             (if (empty? things)
;               answer
;               (iter (m/cdr things)
;                     (cons answer                            ; invalid structure of list here
;                           (m/square (m/car things)))
;     (iter items nil)))
