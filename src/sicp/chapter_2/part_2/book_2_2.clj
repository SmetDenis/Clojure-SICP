(ns sicp.chapter-2.part-2.book-2-2
  (:require [sicp.chapter-1.part-2.book-1-2 :refer [fib]]
            [sicp.misc :as m]))

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
; * 2.30
; * 2.31
; * 2.32

(defn length-tree [tree]
  (reduce (fn [acc _] (inc acc)) 0 tree))

(defn count-leaves [tree]
  (cond
    (number? tree) 1
    (or (empty? tree) (nil? tree)) 0
    :else (+ (count-leaves (m/car tree))
             (count-leaves (m/cdr tree)))))

(defn scale-tree-v0 [tree factor]
  (cond (m/list-empty? tree) nil
        (m/leaf? tree) (* tree factor)
        :else (cons (scale-tree-v0 (first tree) factor)
                    (scale-tree-v0 (rest tree) factor))))

(defn scale-tree [tree factor]
  (map (fn [sub-tree]
         (if (list? sub-tree)
           (scale-tree sub-tree factor)
           (* sub-tree factor)))
       tree))

(comment "2.2.3")
; Sequences as Conventional Interfaces -------------------------------------------------------------
; Exercises:
; * 2.33
; * 2.34
; * 2.35
; * 2.36
; * 2.37
; * 2.38
; * 2.39

(defn sum-odd-squares [tree]
  (cond (m/list-empty? tree) 0
        (m/leaf? tree) (if (odd? tree) (m/square tree) 0)
        :else (+ (sum-odd-squares (first tree))
                 (sum-odd-squares (rest tree)))))

(defn even-fibs [n]
  (letfn [(next [k]
            (if (> k n)
              nil
              (let [f (fib k)]
                (if (even? f)
                  (cons f (next (inc k)))
                  (next (inc k))))))]
    (next 0)))

(defn my-filter [predicate sequence]
  (cond (m/list-empty? sequence) nil
        (predicate (m/car sequence))
        (cons (m/car sequence)
              (my-filter predicate (m/cdr sequence)))
        :else (my-filter predicate (m/cdr sequence))))

(defn accumulate [op initial sequence]
  (if (m/list-empty? sequence)
    initial
    (op (m/car sequence)
        (accumulate op initial (m/cdr sequence)))))

(defn enumerate-interval [low high]
  (if (> low high)
    nil
    (cons low (enumerate-interval (+ low 1) high))))

(defn enumerate-tree [tree]
  (cond (m/list-empty? tree) nil
        (m/leaf? tree) (list tree)
        :else (m/append (enumerate-tree (m/car tree))
                        (enumerate-tree (m/cdr tree)))))

(defn sum-odd-squares-v2 [tree]
  (accumulate
    +
    0
    (map m/square
         (filter odd?
                 (enumerate-tree tree)))))

(defn even-fibs-v2 [n]
  (accumulate
    cons
    nil
    (filter even?
            (map fib
                 (enumerate-interval 0 n)))))

(defn list-fib-squares [n]
  (accumulate
    cons
    nil
    (map m/square
         (map fib
              (enumerate-interval 0 n)))))

(defn product-of-squares-of-odd-elements [sequence]
  (accumulate
    *
    1
    (map m/square (filter odd? sequence))))

; (defn salary-of-highest-paid-programmer [records]
;   (accumulate
;     max
;     0
;     (map salary
;          (filter programmer? records))))
