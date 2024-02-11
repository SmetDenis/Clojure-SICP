(ns sicp.chapter-2.part-2.ex-2-38
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.misc :as m]))

; Exercise 2.38
;
; The accumulate procedure is also known as fold-right, because it combines the first element of
; the sequence with the result of combining all the elements to the right.
;
; There is also a fold-left, which is similar to fold-right, except that it combines elements
; working in the opposite direction:
;
; (define (fold-left op initial sequence)
;   (define (iter result rest)
;     (if (null? rest)
;         result
;         (iter (op result (car rest))
;               (cdr rest))))
;   (iter initial sequence))
;
; What are the values of
;
; (fold-right / 1 (list 1 2 3))
; (fold-left  / 1 (list 1 2 3))
; (fold-right list nil (list 1 2 3))
; (fold-left  list nil (list 1 2 3))
;
; Give a property that op should satisfy to guarantee that fold-right and fold-left
; will produce the same values for any sequence.

(defn fold-right
  [op initial sequence]
  (b22/accumulate op initial sequence))

(defn fold-left
  [op initial sequence]
  (letfn [(iter
            [result rest]
            (if (nil? rest)
              result
              (iter (op result (m/car rest))
                    (m/cdr rest))))]
    (iter initial sequence)))
