(ns sicp.chapter-2.part-2.ex-2-32
  (:require
    [sicp.misc :as m]))

; Exercise 2.32
;
; We can represent a set as a list of distinct elements, and we can represent the set of all subsets
; of the set as a list of lists.
;
; For example, if the set is (1 2 3), then the set of all subsets is
; (() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3)).
;
; Complete the following definition of a procedure that generates the set of subsets
; of a set and give a clear explanation of why it works:
;
; (define (subsets s)
;   (if (null? s)
;       (list nil)
;       (let ((rest (subsets (cdr s))))
;         (append rest (map ⟨??⟩ rest)))))

(defn subsets
  [s]
  (if (empty? s)
    (list '())
    (let [rest (subsets (rest s))]
      (m/append rest (map #(cons (first s) %) rest)))))

; See expanation here https://en.wikipedia.org/wiki/Power_set
