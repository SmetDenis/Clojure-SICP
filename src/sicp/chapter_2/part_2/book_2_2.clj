(ns sicp.chapter-2.part-2.book-2-2
  (:require [sicp.misc :as m]))

(comment "2.2")
; Hierarchical Data and the Closure Property -------------------------------------------------------

(comment
  (m/pair (m/pair 1 2) (m/pair 3 4))                        ; [[1 2] [3 4]]
  (m/pair (m/pair 1 (m/pair 2 3)) 4))                       ; [[1 [2 3]] 4]

(comment "2.2.1")
; Representing Sequences ---------------------------------------------------------------------------

(comment
  (m/pair 1 (m/pair 2 (m/pair 3 (m/pair 4 nil))))           ; [1 [2 [3 [4 nil]]]]
  (list 1 2 3 4)                                            ; (1 2 3 4)
  '(1 2 3 4)                                                ; (1 2 3 4)
  (m/cdr '(1 2 3 4))                                        ; 2
  (m/cdr '(1 (2 (3 4)))))                                   ; (2 (3 4))

(defn list-ref [items n]
  (if (= n 0)
    (m/car items)
    (list-ref (m/cdr items)
              (- n 1))))

(comment
  (def squares '(1 4 9 16 25))
  (list-ref squares 3))                                     ; 16

(defn length-recursice [items]
  (if (empty? items)
    0
    (+ 1 (length-recursice (m/cdr items)))))

(comment
  (length-recursice (list 1 3 5 7)))                        ; 4

(defn length [items]
  (letfn [(length-iter [a count]
            (if (empty? a)
              count
              (length-iter (m/cdr a) (+ 1 count))))]
    (length-iter items 0)))

(comment
  (length (list 1 3 5 7)))                                  ; 4

(defn append [list1 list2]
  (if (empty? list1)
    (if (empty? list2) '() list2)
    (cons (m/car list1)
          (append (m/cdr list1)
                  list2))))

(comment
  (append '(1 4 9 16 25) '(1 3 5 7))                        ; (1 4 9 16 25 1 3 5 7)
  (append '(1 3 5 7) '(1 4 9 16 25)))                       ; (1 3 5 7 1 4 9 16 25)
