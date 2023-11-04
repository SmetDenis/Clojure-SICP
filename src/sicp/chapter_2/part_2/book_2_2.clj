(ns sicp.chapter-2.part-2.book-2-2
  (:require [sicp.misc :as m]))

(comment "2.2")
; Hierarchical Data and the Closure Property -------------------------------------------------------

(comment
  (m/pair (m/pair 1 2) (m/pair 3 4))                        ; [[1 2] [3 4]]
  (m/pair (m/pair 1 (m/pair 2 3)) 4))                       ; [[1 [2 3]] 4]

(comment "2.2.1")
; Representing Sequences ---------------------------------------------------------------------------
; Exercises:
; * 2.17
; * 2.18
; * 2.19
; * 2.20
; * 2.21
; * 2.22
; * 2.23

(comment
  (m/pair 1 (m/pair 2 (m/pair 3 (m/pair 4 nil))))           ; [1 [2 [3 [4 nil]]]]
  (list 1 2 3 4)                                            ; (1 2 3 4)
  '(1 2 3 4)                                                ; (1 2 3 4)
  (m/cdr '(1 2 3 4))                                        ; 2
  (m/cdr '(1 (2 (3 4)))))                                   ; (2 (3 4))

(defn list-ref [lst index]
  (cond
    (< index 0) nil
    (= index 0) (first lst)
    :else (list-ref (rest lst) (dec index))))

(comment
  (def squares '(1 4 9 16 25))
  (list-ref squares 3))                                     ; 16

(defn length-recursice [items]
  (if (m/list-empty? items)
    0
    (+ 1 (length-recursice (m/cdr items)))))

(comment
  (length-recursice (list 1 3 5 7)))                        ; 4

(defn length [list]
  (if (seq list)
    (+ 1 (length (rest list)))
    0))

(comment
  (length (list 1 3 5 7)))                                  ; 4

(defn append [list1 list2]
  (if (empty? list1)
    (if (empty? list2) '() list2)
    (cons (first list1) (append (rest list1) list2))))

(comment
  (append '(1 4 9 16 25) '(1 3 5 7))                        ; (1 4 9 16 25 1 3 5 7)
  (append '(1 3 5 7) '(1 4 9 16 25)))                       ; (1 3 5 7 1 4 9 16 25)

(defn scale-list [items factor]
  (if (m/list-empty? items)
    nil
    (cons (* (m/car items) factor)
          (scale-list (m/cdr items)
                      factor))))

(comment
  (scale-list (list 1 2 3 4 5) 10))                         ; (10 20 30 40 50)

(defn my-map [proc items]
  (println items)
  (if (m/list-empty? items)
    nil
    (cons (proc (m/car items))
          (my-map proc (m/cdr items)))))

(comment
  (my-map abs (list -10 2.5 -11.6 17))                      ; (10 2.5 11.6 17)
  (my-map #(* % %) (list 1 2 3 4)))                         ; (1 4 9 16)

(defn scale-list-2 [items factor]
  (my-map #(* % factor) items))

(comment
  (scale-list-2 (list 1 2 3 4 5) 10))                       ; (10 20 30 40 50)

(comment "2.2.2")
; Hierarchical Structures --------------------------------------------------------------------------
; Exercises:
; * 2.24
; * 2.25
; * 2.26
; * 2.27
; * 2.28
; * 2.29

(defn length-tree [tree]
  (reduce (fn [acc _] (inc acc)) 0 tree))

(defn count-leaves [x]
  (cond
    (number? x) 1
    (or (empty? x) (nil? x)) 0
    :else (+ (count-leaves (first x))
             (count-leaves (rest x)))))
