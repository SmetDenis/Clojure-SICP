(ns sicp.chapter-1.part-1.ex-1-01)

; Exercise 1.1
; Below is a sequence of expressions.
; What is the result printed by the interpreter in response to each expression?
; Assume that the sequence is to be evaluated in the order in which it is presented.

(+ 5 3 4)                                                   ; 12
(dec 9)                                                     ; 8
(/ 6 2)                                                     ; 3
(+ (* 2 4) (- 4 6))                                         ; 6

(def a 3)                                                   ; #'sicp.chapter-1.ex-1-1/a
(def b (inc a))                                             ; #'sicp.chapter-1.ex-1-1/b
(+ a b (* a b))                                             ; 19
(= a b)                                                     ; false

(if (and (> b a) (< b (* a b))) b a)                        ; 4

(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      :else 25)                                             ; 16

(+ 2 (if (> b a) b a))                                      ; 6

(* (cond (> a b) a
         (< a b) b
         :else -1)
   (inc a))                                                 ; 16
